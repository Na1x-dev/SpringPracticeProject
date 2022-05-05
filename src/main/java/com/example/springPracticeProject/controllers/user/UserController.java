package com.example.springPracticeProject.controllers.user;

import com.example.springPracticeProject.models.User;
import com.example.springPracticeProject.services.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = UserEndpoints.userEndpoint)
    public ResponseEntity<?> create(@RequestBody User user){
        userService.create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = UserEndpoints.userEndpoint)
    public ResponseEntity<List<User>> readAll(){
        final List<User> users = userService.readAll();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = UserEndpoints.userIdEndpoint)
    public ResponseEntity<User> read(@PathVariable(name = "id") Long id){
        final User user = userService.read(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = UserEndpoints.userIdEndpoint)
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody User user){
        final boolean updated = userService.update(user, id);
        return updated
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = UserEndpoints.userIdEndpoint)
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        final boolean deleted = userService.delete(id);
        return deleted
                ? new ResponseEntity<>(id, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
