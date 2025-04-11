package com.example.Assignment1;

import java.util.Collection;

public interface CourseServiceInterface {
    Collection<Course> all();
    Course one(Long id);
    Course add(Course course);
    Boolean delete(Long id);
    Course update(Course course);
}
