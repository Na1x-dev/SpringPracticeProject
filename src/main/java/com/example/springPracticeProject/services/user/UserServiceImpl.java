package com.example.springPracticeProject.services.user;

import com.example.springPracticeProject.models.User;
import com.example.springPracticeProject.repositories.user.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean update(User user, Long id) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
