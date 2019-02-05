package com.upwork.service.movie;

import com.upwork.exception.TechnicalFailureException;
import com.upwork.exception.movie.TitleNotFoundException;
import com.upwork.model.Movie;

import java.util.List;

public interface MovieService {

    String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;

    List<Movie> getAllMovies();

}
