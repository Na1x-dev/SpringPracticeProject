package com.example.springPracticeProject.services.message;
//
import com.example.springPracticeProject.models.Message;

import java.util.List;

public interface MessageService {

    void create(Message message);
    List<Message> readAll();

    Message read(Long id);

    boolean update(Message message, Long id);

    boolean delete(Long id);

    List<Message> readByMailId(Long id);
}
