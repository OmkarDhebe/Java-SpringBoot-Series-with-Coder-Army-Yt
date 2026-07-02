package org.example.notification;

public class EmailService implements NotifiactionService {

    @Override
    public void sendNotification(){
        System.out.println("Email notifiaction sent");
    }
}
