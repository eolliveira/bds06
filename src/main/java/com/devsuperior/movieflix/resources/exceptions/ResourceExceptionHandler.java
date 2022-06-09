package com.devsuperior.movieflix.resources.exceptions;

import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
 public class ResourceExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
            int httpStatus = HttpStatus.NOT_FOUND.value();
            StandardError error = new StandardError();
            error.setTimestamp(Instant.now());
            error.setStatus(httpStatus);
            error.setError("Resource not found");
            error.setMessage(e.getMessage());
            error.setPath(request.getRequestURI());
            return ResponseEntity.status(httpStatus).body(error);
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> arguments(MethodArgumentNotValidException e, HttpServletRequest request) {
        int httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();
        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(httpStatus);
        error.setError("Arguments exception");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(httpStatus).body(error);
    }

    }
