package org.example.notification;

public class SmsService implements NotifiactionService {

    @Override
    public void sendNotification(){
        System.out.println("SMS notification sent");
    }
}
