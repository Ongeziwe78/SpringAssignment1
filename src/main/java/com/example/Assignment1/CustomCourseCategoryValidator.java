package com.example.Assignment1;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomCourseCategoryValidator implements ConstraintValidator<CourseCategoryValidator, String> {

    @Override
    public void initialize(CourseCategoryValidator constraintAnnotation) {
    }
    @Override
    public boolean isValid(String category, ConstraintValidatorContext context) {
        String computed = category.toUpperCase().trim();
        return  computed.equals("FOUNDATION")  || computed.equals("UNDERGRADUATE") || computed.equals("HONOURS");
    }
}