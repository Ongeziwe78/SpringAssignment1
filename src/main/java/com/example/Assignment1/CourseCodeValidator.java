package com.example.Assignment1;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomCourseCodeValidator.class)
public @interface CourseCodeValidator {
    String message() default  "Invalid course code 3 digit numbers.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
