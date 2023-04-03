package com.extension.tntExtension.controllerAdvice;

import com.commercetools.api.models.error.ErrorResponse;
import com.extension.tntExtension.exceptionHandlers.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                e.getStatus().value(),
//                e.getMessage(),
//                Collections.singletonList(new Error(e.getClass().getSimpleName(), e.getMessage()))
//        );
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }

}
