package com.upwork.exception.movie;

public class TitleNotFoundException extends Exception {

    public TitleNotFoundException(String message) {
        super("Movie with this titleId not found: " + message);
    }
}
