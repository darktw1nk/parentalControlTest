package com.upwork.repository;

import com.upwork.model.Movie;
import com.upwork.model.ParentalControlLevel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    final HashMap<String, Movie> movies = new HashMap<>();

    public MovieRepositoryImpl() {
        movies.put("Go, get them", new Movie("Go, get them", ParentalControlLevel.LEVEL_U));
        movies.put("Movie", new Movie("Movie", ParentalControlLevel.LEVEL_18));
        movies.put("Broken movie", new Movie("Broken movie", null));
    }

    @Override
    public Optional<Movie> getMovieById(String movieId) {
        return Optional.ofNullable(movies.get(movieId));
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies.values());
    }
}
