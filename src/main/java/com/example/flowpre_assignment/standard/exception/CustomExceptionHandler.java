package com.example.flowpre_assignment.standard.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCustomException(MyCustomException e) {
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode());
    }
}
