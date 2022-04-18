package com.example.springPracticeProject.servicies.message;
//
import com.example.springPracticeProject.models.Message;

import java.util.List;

public interface MessageService {

    void create(Message message);
    List<Message> readAll();

    Message read(int id);

    boolean update(Message message, int id);

    boolean delete(int id);
}
