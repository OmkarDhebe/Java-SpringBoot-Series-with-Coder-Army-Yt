package in.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();

//        AppConfig appConfig =context.getBean(AppConfig.class);
//        appConfig.demo();

        CartService cart = context.getBean(CartService.class);
        System.out.println(cart.getValue(1));
        context.close();

    }
}
