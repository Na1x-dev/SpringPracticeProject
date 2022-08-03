package com.example.springPracticeProject.services.user;

import com.example.springPracticeProject.models.User;
//
import java.util.List;

public interface UserService {

    void create(User user);
    List<User> readAll();

    User read(Long id);

    boolean update(User user, Long id);
    User findByUsername(String username);

    boolean delete(Long id);
}
