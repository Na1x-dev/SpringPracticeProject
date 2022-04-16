package com.example.springPracticeProject.repositories;

import com.example.springPracticeProject.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {}
