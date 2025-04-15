package com.example.Assignment1;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CourseController {
    private  final CourseService service;
    @GetMapping("/")
    public ResponseEntity<Collection<Course>> all(){
//        return ResponseEntity.ok(this.service.all());
        return  ResponseEntity.status(200).body(this.service.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> one(@PathVariable Long id){
        return  ResponseEntity.status(200).body(this.service.one(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable Long id){
        return  ResponseEntity.status(200).body(this.service.delete(id));
    }

    @PostMapping("/")
    public ResponseEntity<Course> add(@Valid @RequestBody JsonBody body){
        Course course = new Course();
        course.setCategory(body.getCategory().trim().toUpperCase());
        course.setDescription(body.getDescription().trim());
        course.setCode(body.getCode());
        course.setName(body.getName().trim().toUpperCase());
        String fullName = course.getName().trim().toUpperCase().concat(" " + course.getCode());
        if(body.getCategory().trim().equalsIgnoreCase( "FOUNDATION")){
            fullName = fullName + "F";
        }
        course.setFullName(fullName);
        boolean found = this.service.findByFullName(course.getFullName());
        if(found){
            throw new CourseAlreadyExistsException("The course already exists");
        }
        return  ResponseEntity.status(201).body(this.service.add(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(
            @Valid @RequestBody JsonBody body,
            @PathVariable("id") Long id
    ){
        Course course = this.service.one(id);
        course.setCategory(body.getCategory().trim().toUpperCase());
        course.setDescription(body.getDescription().trim());
        course.setCode(body.getCode());
        course.setName(body.getName().trim().toUpperCase());
        String fullName = course.getName().trim().toUpperCase().concat(" " + course.getCode());
        if(body.getCategory().trim().equalsIgnoreCase( "FOUNDATION")){
            fullName = fullName + "F";
        }
        course.setFullName(fullName);
        return  ResponseEntity.ok(this.service.update(course));
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ArrayList<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException exception){
        ArrayList<Map<String,String>> errors = new ArrayList<Map<String, String>>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            Map<String, String> e = new HashMap<>();
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            e.put(field, message);
            e.put("timestamp", new Date().toString());
            e.put("field", field);
            errors.add(e);
        });
        return errors;
    }
}
