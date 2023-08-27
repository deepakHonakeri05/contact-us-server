package com.example.contactus.service;

import com.example.contactus.model.Message;
import com.example.contactus.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public ResponseEntity<String> saveMessage(Message message) {
        messageRepository.save(message);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public ResponseEntity<String> deleteMessage(Long id) {
        messageRepository.deleteById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
