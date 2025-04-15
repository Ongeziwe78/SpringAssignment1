package com.example.Assignment1;

public class CourseNotFoundException extends RuntimeException{
    public  CourseNotFoundException(String message){
        super(message);
    }
}