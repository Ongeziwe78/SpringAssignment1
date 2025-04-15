package com.example.Assignment1;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.*;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> courseNotFound(CourseNotFoundException exception, WebRequest request) {
        ArrayList<ErrorType> errors = new ArrayList<>();
        errors.add(
                new ErrorType(
                        exception.getMessage(), "course not found"
                )
        );
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseAlreadyExistsException.class)
    public ResponseEntity<?> courseAlreadyExists(CourseAlreadyExistsException exception, WebRequest request) {
        ArrayList<ErrorType> errors = new ArrayList<>();
        errors.add(
                new ErrorType(
                        exception.getMessage(), "course already exists."
                )
        );
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ArrayList<Object>> handleResourceNotFound(NoResourceFoundException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", "Resource not found");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", ex.getResourcePath());
        ArrayList<Object> errors = new ArrayList<>();
        errors.add(errorDetails);
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

}
