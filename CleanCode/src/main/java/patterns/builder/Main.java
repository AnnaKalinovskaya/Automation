package patterns.builder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        new ShopOrder.Builder()
                .setDiscount(0.5)
                .setPaymentType("Online")
                .setProducts(List.of("Book", "Pen"))
                .build();

        new Character.Builder()
                .setHealth("full")
                .setMagic("invisible")
                .build();
    }
}
