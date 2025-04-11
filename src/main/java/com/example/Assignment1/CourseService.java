package com.example.Assignment1;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class CourseService implements  CourseServiceInterface{


    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Course> all() {
        return this.repository.findAll().stream().toList();
    }

    @Override
    public Course one(Long id) {
        return null;
    }

    @Override
    public Course add(Course course) {
        //
        return this.repository.save(course);
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Course update(Course course) {
        return null;
    }
}
