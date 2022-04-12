package com.example.springPracticeProject.repositories;

import com.example.springPracticeProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
