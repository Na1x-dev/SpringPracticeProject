package com.example.springPracticeProject.servicies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//
@Service
public class TestServiceImpl implements TestService{


    @Override
    public ResponseEntity<?> get(int number) {
        return number % 2 == 0
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
