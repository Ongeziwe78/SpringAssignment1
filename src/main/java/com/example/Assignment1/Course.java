package com.example.Assignment1;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
            @SequenceGenerator(
                    name="course_sequence", allocationSize = 1,
                    sequenceName = "course_sequence"
            )
      @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private int code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String fullName;
}
