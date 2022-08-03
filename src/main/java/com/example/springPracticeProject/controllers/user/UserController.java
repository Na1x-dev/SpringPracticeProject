package com.example.springPracticeProject.controllers.user;

import com.example.springPracticeProject.models.User;
import com.example.springPracticeProject.services.security.SecurityService;
import com.example.springPracticeProject.services.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signUpPage/index")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/receivedMessages/index";
        }
        User user = new User();
        model.addAttribute("userForm", user);
       // System.out.println(user.getUserName());
        return "signUpPage/index";
    }

    @PostMapping("/signUpPage/index")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        System.out.println("gg");
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signUpPage/index";
        }

        userService.create(userForm);

        securityService.autoLogin(userForm.getUserName(), userForm.getPasswordConfirm());

        return "redirect:/receivedMessages/index";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/receivedMessages/index";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/receivedMessages/index"})
    public String welcome(Model model) {
        return "receivedMessages/index";
    }}