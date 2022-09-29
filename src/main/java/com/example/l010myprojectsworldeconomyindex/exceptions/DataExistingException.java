package com.example.l010myprojectsworldeconomyindex.exceptions;

public class DataExistingException extends RuntimeException {

    private String message;

    public DataExistingException() {
    }

    public DataExistingException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
