package com.upwork.service.parental;

import com.upwork.TestApplicationConfiguration;
import com.upwork.message.parental.ParentalControlResponse;
import com.upwork.model.ParentalControlLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class ParentalControlServiceImplTest {

    @Autowired
    ParentalControlServiceImpl parentalControlService;

    @Test
    public void canWatchMovieTrue(){
        ParentalControlResponse response = parentalControlService.canWatchMovie(ParentalControlLevel.LEVEL_18,"Go, get them");

        assertNotNull(response);
        assertThat(response.isCanWatch(),is(true));
    }

    @Test
    public void canWatchMovieFalse(){
        ParentalControlResponse response = parentalControlService.canWatchMovie(ParentalControlLevel.LEVEL_U,"Movie");

        assertNotNull(response);
        assertThat(response.isCanWatch(),is(false));
    }

    @Test
    public void canWatchMovieTitleNotFound(){
        ParentalControlResponse response = parentalControlService.canWatchMovie(ParentalControlLevel.LEVEL_18,"Bad movie");

        assertNotNull(response);
        assertThat(response.isCanWatch(),is(false));
        assertThat(response.getError(),containsString("Movie with this titleId not found"));
    }

    @Test
    public void canWatchMovieTechnicalFailure(){
        ParentalControlResponse response = parentalControlService.canWatchMovie(ParentalControlLevel.LEVEL_18,"Broken movie");

        assertNotNull(response);
        assertThat(response.isCanWatch(),is(false));
        assertThat(response.getError(),containsString("Technical Failure"));
    }

}
