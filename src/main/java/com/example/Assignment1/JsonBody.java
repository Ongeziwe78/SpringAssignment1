package com.example.Assignment1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class JsonBody{
    @Valid
    @NotNull(message = "The course code is required.")
    @CourseCodeValidator
    private int code;

    @NotNull(message = "The course name is required.")
    @Size(max = 3, min = 3, message = "The course name must have exactly 3 characters.")
    private String name;

    @NotNull(message = "The course category is required.")
    @CourseCategoryValidator
    private String category;

    @NotNull(message = "The course description is required.")
    private String description;
}


