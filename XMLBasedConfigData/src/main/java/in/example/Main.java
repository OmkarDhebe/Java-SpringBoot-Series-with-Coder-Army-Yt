package in.example;

import in.example.payment.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//    OrderService order = context.getBean(OrderService.class);

//    OrderService order = (OrderService) context.getBean("orderService");
////    order.orderPlaced();
//
//    PaymentService paymentService = context.getBean("paymentService" ,PaymentService.class);
//paymentService.pay();

//    OrderService orderService= context.getBean("orderService",OrderService.class);
//    orderService.orderPlaced();

    UserService userService = context.getBean(UserService.class);

//    System.out.println(userService.getUsernames());

    context.close();
     }
}
