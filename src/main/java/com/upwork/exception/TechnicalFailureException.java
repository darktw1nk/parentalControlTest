package com.upwork.exception;

public class TechnicalFailureException extends Exception {


    public TechnicalFailureException(String message) {
        super("Technical Failure: "+message);
    }
}
