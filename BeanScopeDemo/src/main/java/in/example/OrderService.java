package in.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope("singleton")  // Scope as default singleton
//@Scope("prototype")
public class OrderService {

    public OrderService(){
        System.out.println("OrderService Created");
    }

    public void pay(){
        System.out.println("Placedd Order");
    }

}
