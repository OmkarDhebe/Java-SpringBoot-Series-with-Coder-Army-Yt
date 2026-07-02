package in.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void main(String[] argsg) {
//        PaymentService service = new PaymentService();
//OrderService order = new OrderService(service);
//order.placeOrder();

        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
 order.placeOrder();
// PaymentService payment = context.getBean(PaymentService.class);
// payment.pay();

    }



}
