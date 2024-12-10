package code.godobject.shoppingcart;

public class ShoppingCartMain {
    public static void main(String[] args) {
        CartManager cartManager = new CartManager();
        PriceCalculator priceCalculator = new PriceCalculator();
        CheckoutService checkoutService = new CheckoutService();

        cartManager.addItem();
        priceCalculator.calculateTotal();
        priceCalculator.applyDiscount();
        checkoutService.checkout();
    }
}
