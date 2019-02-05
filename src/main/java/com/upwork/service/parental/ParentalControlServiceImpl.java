package com.upwork.service.parental;

import com.upwork.exception.TechnicalFailureException;
import com.upwork.exception.movie.TitleNotFoundException;
import com.upwork.message.parental.ParentalControlResponse;
import com.upwork.message.parental.ParentalControlResponseBuilder;
import com.upwork.model.ParentalControlLevel;
import com.upwork.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentalControlServiceImpl implements ParentalControlService {

    @Autowired
    MovieService movieService;

    @Override
    public ParentalControlResponse canWatchMovie(ParentalControlLevel level, String movieId) {
        ParentalControlResponse response;
        ParentalControlResponseBuilder builder = new ParentalControlResponseBuilder();

        try {
            ParentalControlLevel movieLevel = ParentalControlLevel.fromString(movieService.getParentalControlLevel(movieId)).get();
            response = builder.setCanWatch(movieLevel.getIntLevel() <= level.getIntLevel()).setMessage("request status: 200").createParentalControlResponse();
        } catch (TitleNotFoundException | TechnicalFailureException e) {
            response = builder.setCanWatch(false).setError(e.getMessage()).createParentalControlResponse();
        } catch (Exception e) {
            response = builder.setCanWatch(false).setError("Theres is internal error").createParentalControlResponse();
        }

        return response;
    }
}
