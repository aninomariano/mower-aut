package com.seatcode.moweraut.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { HttpServerErrorException.class })
    public ResponseEntity<Object> handleExternalServerError() {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ApiException.builder()
                .status(INTERNAL_SERVER_ERROR)
                .message("Repository failure.")
                .build());
    }

    @ExceptionHandler(value = { MowerNotFoundException.class })
    public ResponseEntity<Object> handleMowerNotFoundException() {
        return ResponseEntity.status(NOT_FOUND).body(ApiException.builder()
                .status(NOT_FOUND)
                .message("Resource not found.")
                .build());
    }

    @ExceptionHandler(value = { NullPointerException.class })
    public ResponseEntity<Object> internalApiError() {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ApiException.builder()
                .status(INTERNAL_SERVER_ERROR)
                .message("Something went wrong.")
                .build());
    }
}