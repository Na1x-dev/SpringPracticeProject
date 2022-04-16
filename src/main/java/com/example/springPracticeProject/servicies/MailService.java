package com.example.springPracticeProject.servicies;
///
import com.example.springPracticeProject.models.Mail;
import java.util.List;

public interface MailService {

    void create(Mail mail);
    List<Mail> readAll();

    Mail read(int id);

    boolean update(Mail mail, int id);

    boolean delete(int id);
}
