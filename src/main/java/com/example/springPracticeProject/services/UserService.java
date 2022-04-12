package com.example.springPracticeProject.services;

import org.springframework.http.ResponseEntity;

public interface TestService {

    ResponseEntity<?> get(int number);
}
