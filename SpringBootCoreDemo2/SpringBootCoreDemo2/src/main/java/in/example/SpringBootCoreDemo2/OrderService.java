package in.example.SpringBootCoreDemo2;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    PaymentService paymentService;

    public  OrderService(){
        paymentService = new PaymentService();
    }

    public void orderPlaced(){
        paymentService.pay();
        System.out.println("Order Placed");
    }

}
