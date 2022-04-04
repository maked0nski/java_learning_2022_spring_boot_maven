package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.models.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO exception1(RuntimeException e) {
        return new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), "some error");
    }

}
