package com.example.springPracticeProject.controllers;

import com.example.springPracticeProject.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/{number}")
    public ResponseEntity<?> get(@PathVariable(name = "number") int number) {
        return this.testService.get(number);
    }

}
