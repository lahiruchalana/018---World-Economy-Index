package com.example.l010myprojectsworldeconomyindex.exceptions.models;

import org.springframework.http.HttpStatus;

public class CommonExceptionModel {

    private HttpStatus httpStatus;
    private String message;
    private String exceptionId;

    public CommonExceptionModel() {
    }

    public CommonExceptionModel(HttpStatus httpStatus, String message, String exceptionId) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.exceptionId = exceptionId;
    }
}
