package com.example.springPracticeProject.controllers;

import com.example.springPracticeProject.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
