package principles.ocp;

public class PayPalPayment extends Payment {

    public void pay(double amount){
        System.out.println("Оплата через PayPal на сумму " + amount);
    }
}
