package com.example.flowpre_assignment.standard.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    //@ExceptionHandler({AddDefaultExtensionException.class, AddDuplicateExtensionException.class, ExceededMaxQuantityException.class})
    @ExceptionHandler(AddDefaultExtensionException.class)
    protected ResponseEntity<ErrorResponseEntity> handleAddDefaultExtensionException(AddDefaultExtensionException e) {
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(AddDuplicateExtensionException.class)
    protected ResponseEntity<ErrorResponseEntity> handleAddDuplicateExtensionException(AddDuplicateExtensionException e) {
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(ExceededMaxQuantityException.class)
    protected ResponseEntity<ErrorResponseEntity> handleExceededMaxQuantityException(ExceededMaxQuantityException e) {
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode());
    }
}
