package principles;

public class DiscountCalculator {

    public double calculateDiscount(double price, boolean isLoyalCustomer, boolean isFirstPurchase, boolean hasCoupon) {

        if (isLoyalCustomer && isFirstPurchase) {
            return price * 0.10;
        }
        else if (isLoyalCustomer) {
            return price * 0.05;
        }
        else if (hasCoupon) {
            return price * 0.07;
        }

        return price * 0.02;
    }
}
