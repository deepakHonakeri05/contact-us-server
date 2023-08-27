package com.example.contactus.controller;

import com.example.contactus.model.Message;
import com.example.contactus.service.MessageService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/save")
    public ResponseEntity<String> saveMessage(@RequestBody Message message) throws FirebaseMessagingException {
        return messageService.saveMessage(message);
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id){
        return messageService.deleteMessage(id);
    }
}
