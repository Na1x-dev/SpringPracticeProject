package com.example.springPracticeProject.servicies;

import com.example.springPracticeProject.models.Message;
import com.example.springPracticeProject.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void create(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> readAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message read(int id) {
        return messageRepository.getById(id);
    }

    @Override
    public boolean update(Message message, int id) {
        if (messageRepository.existsById(id)) {
            message.setId(id);
            messageRepository.save(message);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
