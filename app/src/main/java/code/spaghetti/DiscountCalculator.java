package code.spaghetti;

enum CustomerType {
    REGULAR, VIP
}

interface DiscountStrategy {
    double calculateDiscount(int purchaseAmount);
}

class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(int purchaseAmount) {
        return purchaseAmount > 100 ? 10 : 5;
    }
}

class VIPCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(int purchaseAmount) {
        return purchaseAmount > 500 ? 20 : 15;
    }
}

public class DiscountCalculator {
    public double calculateDiscount(CustomerType customerType, int purchaseAmount) {
        DiscountStrategy strategy;
        switch (customerType) {
            case REGULAR:
                strategy = new RegularCustomerDiscount();
                break;
            case VIP:
                strategy = new VIPCustomerDiscount();
                break;
            default:
                throw new IllegalArgumentException("Unknown customer type");
        }
        return strategy.calculateDiscount(purchaseAmount);
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Discount for REGULAR customer: " + calculator.calculateDiscount(CustomerType.REGULAR, 120));
        System.out.println("Discount for VIP customer: " + calculator.calculateDiscount(CustomerType.VIP, 600));
    }
}