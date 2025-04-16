package principles.ocp;

public class BitcoinPayment extends Payment {

    public void pay(double amount){
        System.out.println("Оплата Bitcoin на сумму " + amount);
    }
}
