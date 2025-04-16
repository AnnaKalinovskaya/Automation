package principles.ocp;

public class CreditCardPayment extends Payment {

    public void pay(double amount){
        System.out.println("Оплата кредитной картой на сумму " + amount);
    }
}
