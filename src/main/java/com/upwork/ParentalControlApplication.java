package com.upwork;

import com.upwork.model.ParentalControlLevel;
import com.upwork.service.movie.MovieService;
import com.upwork.service.parental.ParentalControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class ParentalControlApplication implements CommandLineRunner {

    @Autowired
    private ConfigurableApplicationContext context;
    @Autowired
    ParentalControlService parentalControlService;
    @Autowired
    MovieService movieService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome");
        System.out.println("Set you parental level");
        System.out.println("Next Parental level available:");
        Arrays.stream(ParentalControlLevel.values()).map(ParentalControlLevel::getName).forEach(System.out::println);
        System.out.println();

        ParentalControlLevel userLevel = null;
        while (userLevel == null) {
            String line = scanner.nextLine();
            Optional<ParentalControlLevel> inputLevel = ParentalControlLevel.fromString(line);
            if (inputLevel.isPresent()) {
                userLevel = inputLevel.get();
            } else {
                System.out.println("Cant parse you parental control level");
                System.out.println("try again");
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Enter one of the movie names below");
        System.out.println("Or enter 'quit' to exit");
        System.out.println();
        movieService.getAllMovies().forEach(System.out::println);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("quit")) {
                System.exit(SpringApplication.exit(context));
            } else {
                System.out.println(parentalControlService.canWatchMovie(userLevel, line));
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ParentalControlApplication.class, args);
    }

}

