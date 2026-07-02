package org.example.notification;

public class FakeEmailService implements NotifiactionService{

   @Override
    public  void sendNotification(){
       System.out.println("Fake Email is sent");
   }
}
