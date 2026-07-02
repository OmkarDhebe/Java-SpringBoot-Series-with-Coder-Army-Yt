package in.example.payment;

public class UpiPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
