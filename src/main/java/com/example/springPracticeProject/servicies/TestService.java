package com.example.springPracticeProject.servicies;

import org.springframework.http.ResponseEntity;
//
public interface TestService {

    ResponseEntity<?> get(int number);
}
