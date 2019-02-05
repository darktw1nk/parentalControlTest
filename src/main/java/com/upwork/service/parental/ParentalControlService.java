package com.upwork.service.parental;

import com.upwork.message.parental.ParentalControlResponse;
import com.upwork.model.ParentalControlLevel;

public interface ParentalControlService {

    ParentalControlResponse canWatchMovie(ParentalControlLevel level, String movieId);

}
