package in.example;

import in.example.payment.PaymentService;


public class OrderService {

    private PaymentService paymentService;

//    public OrderService(PaymentService paymentService){
//        this.paymentService = paymentService;
//        System.out.println("OrderService Created");
//    }

//
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("OrderService Created");
    }

    public void orderPlaced(){
//        paymentService.pay();
        System.out.println("Order Placed");
    }

}
