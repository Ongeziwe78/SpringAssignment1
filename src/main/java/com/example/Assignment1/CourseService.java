package com.example.Assignment1;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;


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
        if(this.repository.findById(id).isEmpty()){
            throw new CourseNotFoundException("The course with id '%d' does not exists.".formatted(id));
        }
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public Course add(Course course) {
        //
        return this.repository.save(course);
    }

    @Override
    public Boolean delete(Long id) {
        if(this.repository.findById(id).isEmpty()){return  false;}
        this.repository.deleteById(id);
        return  true;
    }

    @Override
    public boolean findByFullName(String fullName){
        return this.repository.findByFullName(fullName).isPresent();
    }

    @Override
    public Course update(Course course) {
        return this.repository.save(course);
    }
}
