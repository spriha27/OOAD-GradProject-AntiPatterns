package java.code.goldenhammer.product;

public class ECommerceApplication {
    private ProductService productService;
    private OrderService orderService;

    public ECommerceApplication(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public void run() {
        productService.listProducts();
        orderService.placeOrder("Product123");
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        ECommerceApplication app = new ECommerceApplication(productService, orderService);
        app.run();
    }
}
