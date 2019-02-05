package com.upwork.message.parental;

public class ParentalControlResponse {
    boolean canWatch;
    String message;
    String error;

    public ParentalControlResponse(boolean canWatch, String message,String error) {
        this.canWatch = canWatch;
        this.message = message;
        this.error = error;
    }

    public boolean isCanWatch() {
        return canWatch;
    }

    public void setCanWatch(boolean canWatch) {
        this.canWatch = canWatch;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ParentalControlResponse{" +
                "canWatch=" + canWatch +
                ", message='" + message + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
