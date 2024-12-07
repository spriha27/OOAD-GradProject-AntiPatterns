package java.code.dataclass;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public double applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }
        return price - (price * discountPercentage / 100);
    }

    public static void main(String[] args) {
        Product product = new Product("Laptop", 1000.0);
        System.out.println("Product Name: " + product.getName());
        System.out.println("Original Price: $" + product.getPrice());

        double discountedPrice = product.applyDiscount(10.0);
        System.out.println("Discounted Price: $" + discountedPrice);
    }
}