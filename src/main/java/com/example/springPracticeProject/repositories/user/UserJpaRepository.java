package com.example.springPracticeProject.repositories.user;
//
import com.example.springPracticeProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {}
