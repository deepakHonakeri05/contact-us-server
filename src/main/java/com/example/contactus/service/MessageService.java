package com.example.contactus.service;

import com.example.contactus.model.Message;
import com.example.contactus.repository.MessageRepository;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    private final NotificationService notificationService;

    public MessageService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    public ResponseEntity<String> saveMessage(Message message) throws FirebaseMessagingException {
        String response = "Failure";
        if((!message.getMessage().equals("") && message.getMessage()!=null) &&
                (!message.getName().equals("") && message.getName()!=null) &&
                (!message.getEmail().equals("") && message.getEmail()!=null)
        ) {
            //save the message
            messageRepository.save(message);
            response = notificationService.sendNotification(message,"notificationChannel");
            System.out.println("Sent notification to me!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public ResponseEntity<String> deleteMessage(Long id) {
        messageRepository.deleteById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
