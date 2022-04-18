package com.example.springPracticeProject.controllers.mail;

import com.example.springPracticeProject.models.Mail;
import com.example.springPracticeProject.servicies.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class MailController {

    private final MailService mailService;

    @PostMapping(value = "/mails")
    public ResponseEntity<?> create(@RequestBody Mail mail){
        mailService.create(mail);
        return new ResponseEntity<>(mail, HttpStatus.CREATED);
    }

    @GetMapping(value = "/mails")
    public ResponseEntity<List<Mail>> readAll(){
        final List<Mail> mails = mailService.readAll();
        return mails != null && !mails.isEmpty()
                ? new ResponseEntity<>(mails, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/mails/{id}")
    public ResponseEntity<Mail> read(@PathVariable(name = "id") int id){
        final Mail mail = mailService.read(id);
        return mail != null
                ? new ResponseEntity<>(mail, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/mails/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Mail mail){
        final boolean updated = mailService.update(mail, id);
        return updated
                ? new ResponseEntity<>(mail, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/mails/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = mailService.delete(id);
        return deleted
                ? new ResponseEntity<>(id, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}