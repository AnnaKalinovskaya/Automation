package patterns.builder;

import java.util.LinkedList;
import java.util.List;

class ShopOrder {

    private List<String> productsList = new LinkedList<>();
    private double discount;
    private String paymentType;

    ShopOrder (LinkedList<String> productsList, double discount, String paymentType){
        this.discount = discount;
        this.paymentType = paymentType;
        this.productsList = productsList;
    }

    ShopOrder (Builder builder){
        this.discount = builder.discount;
        this.paymentType = builder.paymentType;
        this.productsList = builder.productsList;
    }

    static class Builder{
        private List<String> productsList = new LinkedList<>();
        private double discount;
        private String paymentType;

        Builder setProducts(List<String> list){
            this.productsList = list;
            return this;
        }

        Builder setPaymentType(String paymentType){
            this.paymentType = paymentType;
            return this;
        }

        Builder setDiscount (double discount){
            this.discount = discount;
            return this;
        }

        ShopOrder build(){
            return new ShopOrder(this);
        }

    }


}
