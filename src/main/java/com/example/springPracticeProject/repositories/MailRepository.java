package com.example.springPracticeProject.repositories;
//
import com.example.springPracticeProject.models.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Integer> {}
