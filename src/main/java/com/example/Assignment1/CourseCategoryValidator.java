package com.example.Assignment1;
import jakarta.validation.*;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomCourseCategoryValidator.class)
public @interface CourseCategoryValidator {
    String message() default "Invalid course category.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}