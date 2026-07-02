package org.example;

import org.example.notification.EmailService;
import org.example.notification.NotifiactionService;

public class OrderService {
NotifiactionService notification ;
    public OrderService(NotifiactionService notification){
 this.notification=notification;
    }
    public OrderService(){

    }


    public void placeOrder(){
        System.out.println("Order Placed");
    notification.sendNotification();
    }

    public void setNotification(NotifiactionService notification) {
        this.notification = notification;
    }

}
