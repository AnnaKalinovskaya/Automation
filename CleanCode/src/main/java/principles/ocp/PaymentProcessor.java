package principles.ocp;

public class PaymentProcessor {

    public void processPayment(Payment paymentType, double amount) {
        paymentType.pay(amount);
    }
}
