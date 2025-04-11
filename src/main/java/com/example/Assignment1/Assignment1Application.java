package com.example.Assignment1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
	}

	@GetMapping("/")
	public static ArrayList<Course> hello(){
        int[] codes = { 113, 212, 312, 313 };
        ArrayList<Course> courses = new ArrayList<Course>();
        for(int code : codes){
            courses.add(new Course(code, "CSC", "CSC " + code));
        }
	    return courses;
	}
}
