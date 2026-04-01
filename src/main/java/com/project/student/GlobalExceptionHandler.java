package com.project.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentKhoGya.class)
    public ResponseEntity<String> handleNotFound(StudentKhoGya re){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage());
    }
}
