package com.upwork.service.movie;

import com.upwork.exception.TechnicalFailureException;
import com.upwork.exception.movie.TitleNotFoundException;
import com.upwork.model.Movie;
import com.upwork.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {

        Optional<Movie> optMovie = movieRepository.getMovieById(movieId);

        if (optMovie.isPresent()) {
            Movie movie = optMovie.get();
            if (movie.getLevel() == null) {
                throw new TechnicalFailureException("parental control level not set for movie: " + movie.getName());
            } else {
                return movie.getLevel().getName();
            }
        } else {
            throw new TitleNotFoundException("there is no title with such id: " + movieId);
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }
}
