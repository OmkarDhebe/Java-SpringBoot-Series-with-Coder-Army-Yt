package in.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class PaymentService {

    public PaymentService(){
        System.out.println("PaymentService is created");
    }

}
