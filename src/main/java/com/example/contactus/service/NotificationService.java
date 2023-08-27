package com.example.contactus.service;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final FirebaseMessaging firebaseMessaging;

    public NotificationService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification(com.example.contactus.model.Message message) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(message.getName()+" "+message.getEmail())
                .setBody(message.getMessage())
                .build();

        Message messageNotification = Message
                .builder()
                .setNotification(notification)
                .build();

        return firebaseMessaging.send(messageNotification);
    }

}
