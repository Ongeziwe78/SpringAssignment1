package com.example.Assignment1;

public class CourseAlreadyExistsException extends RuntimeException {
    public CourseAlreadyExistsException(String message){
        super(message);
    }
}
