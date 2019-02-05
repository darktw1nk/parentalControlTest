package com.upwork.message.parental;

public class ParentalControlResponseBuilder {
    private boolean canWatch;
    private String message;
    private String error;

    public ParentalControlResponseBuilder setCanWatch(boolean canWatch) {
        this.canWatch = canWatch;
        return this;
    }

    public ParentalControlResponseBuilder setError(String error) {
        this.error = error;
        return this;
    }

    public ParentalControlResponseBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ParentalControlResponse createParentalControlResponse() {
        return new ParentalControlResponse(canWatch, message,error);
    }
}