package org.example.queryservice.exception;

import org.example.queryservice.controller.PriceController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = PriceController.class)
public class GlobalExceptionHandler {

    // Handle custom PriceNotFoundException
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<String> handlePriceNotFoundException(PriceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);  // HTTP 404
    }

}
