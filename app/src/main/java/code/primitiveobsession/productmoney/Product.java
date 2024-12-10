package code.primitiveobsession.productmoney;

import java.math.BigDecimal;

public class Product {
    private Money price;

    public Product(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Money price = new Money(BigDecimal.valueOf(19.99));
        Product product = new Product(price);
        System.out.println("Product price: $" + product.getPrice().getAmount());
    }
}