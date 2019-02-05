package com.upwork.repository;

import com.upwork.exception.movie.TitleNotFoundException;
import com.upwork.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

        Optional<Movie> getMovieById(String movieId);

        List<Movie> getAllMovies();
}
