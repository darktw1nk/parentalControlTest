package com.upwork.repository;

import com.upwork.TestApplicationConfiguration;
import com.upwork.model.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class MovieRepositoryImplTest {

    @Autowired
    private MovieRepositoryImpl movieRepository;

    @Test
    public void getMovieByIdExist(){
        Optional<Movie> movie = movieRepository.getMovieById("Movie");

        assertTrue(movie.isPresent());
        assertThat(movie.get().getName(),is("Movie"));
    }

    @Test
    public void getMovieByIdNotExist(){
        Optional<Movie> movie = movieRepository.getMovieById("Bad Movie");

        assertFalse(movie.isPresent());
    }

    @Test
    public void getAllMovies(){
        List<Movie> movies = movieRepository.getAllMovies();

        assertNotNull(movies);
        assertThat(movies.size(),is(3));
    }

}
