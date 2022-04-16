package com.example.springPracticeProject.controllers;

import com.example.springPracticeProject.models.Message;
import com.example.springPracticeProject.servicies.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/messages")
    public ResponseEntity<?> create(@RequestBody Message message){
        messageService.create(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/messages")
    public ResponseEntity<List<Message>> readAll(){
        final List<Message> messages = messageService.readAll();
        return messages != null && !messages.isEmpty()
                ? new ResponseEntity<>(messages, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/messages/{id}")
    public ResponseEntity<Message> read(@PathVariable(name = "id") int id){
        final Message message = messageService.read(id);
        return message != null
                ? new ResponseEntity<>(message, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/messages/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Message message){
        final boolean updated = messageService.update(message, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/massages/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = messageService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
