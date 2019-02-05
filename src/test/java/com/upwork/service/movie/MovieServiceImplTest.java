package com.upwork.service.movie;

import com.upwork.TestApplicationConfiguration;
import com.upwork.exception.TechnicalFailureException;
import com.upwork.exception.movie.TitleNotFoundException;
import com.upwork.model.Movie;
import com.upwork.model.ParentalControlLevel;
import com.upwork.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class MovieServiceImplTest {

    @Autowired
    MovieServiceImpl movieService;

    @Test
    public void getParentalControlLevelCorrect() throws TechnicalFailureException, TitleNotFoundException {
        String parentalControlLevel = movieService.getParentalControlLevel("Movie");

        assertNotNull(parentalControlLevel);
        assertThat(parentalControlLevel,is(ParentalControlLevel.LEVEL_18.getName()));
    }

    @Test(expected = TitleNotFoundException.class)
    public void getParentalControlLevelTitleNotFoundException() throws TechnicalFailureException, TitleNotFoundException {
        movieService.getParentalControlLevel("Bad Movie");
    }

    @Test(expected = TechnicalFailureException.class)
    public void getParentalControlLevelTechnicalFailureException() throws TechnicalFailureException, TitleNotFoundException {
        movieService.getParentalControlLevel("Broken movie");
    }

    @Test
    public void getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();

        assertNotNull(movies);
        assertThat(movies.size(),is(3));
    }

}
