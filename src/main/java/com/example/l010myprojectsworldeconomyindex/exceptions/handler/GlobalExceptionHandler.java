package com.example.l010myprojectsworldeconomyindex.exceptions.handler;

import com.example.l010myprojectsworldeconomyindex.exceptions.DataExistingException;
import com.example.l010myprojectsworldeconomyindex.exceptions.models.CommonExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataExistingException.class)
    public ResponseEntity handleDataExistException(DataExistingException e) {
        System.out.println(e);
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(new CommonExceptionModel(
                HttpStatus.ALREADY_REPORTED,
                e.getMessage(),
                "currencies.already-exist"
        ));
    }
}
