package com.example.springPracticeProject.repositories.mail;
//
import com.example.springPracticeProject.models.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailJpaRepository extends JpaRepository<Mail, Long> {}
