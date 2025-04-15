package com.example.Assignment1;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorType {
    private String message;
    private String details;
}