package com.example.Assignment1;
import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @SequenceGenerator(name="course_sequence", allocationSize = 1, sequenceName = "course_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private int code;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, length = 3)
    private String name;

    @Column(nullable = false, unique = true, length = 8, name = "fullName")
    private String fullName;

    @Column(nullable = false, name = "description")
    private String description;
}
