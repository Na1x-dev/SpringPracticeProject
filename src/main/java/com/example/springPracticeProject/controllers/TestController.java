package com.example.springPracticeProject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    public TestController() {
    }

    @GetMapping(value = "/{number}")
    public ResponseEntity<?> get(@PathVariable(name = "number") int number) {
        return number % 2 == 0
                        ? new ResponseEntity<>(HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
