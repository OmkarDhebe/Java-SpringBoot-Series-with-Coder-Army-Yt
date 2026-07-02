package org.example;

import org.example.notification.EmailService;
import org.example.notification.FakeEmailService;
import org.example.notification.NotifiactionService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        NotifiactionService notification = new EmailService();
//        OrderService order = new OrderService(notification);
OrderService order = new OrderService();
order.setNotification(notification);
        order.placeOrder();
//    System.out.println("Hello World!");
    }
}
