package com.market.market.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<CustomErrorResponse> handleMissingPathVariableException(MissingPathVariableException exception, WebRequest request)
    {
        return new ResponseEntity<>(new CustomErrorResponse("error", exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
