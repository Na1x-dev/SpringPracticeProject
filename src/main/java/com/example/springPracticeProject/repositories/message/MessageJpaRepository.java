package com.example.springPracticeProject.repositories.message;
//
import com.example.springPracticeProject.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageJpaRepository extends JpaRepository<Message, Long> {}
