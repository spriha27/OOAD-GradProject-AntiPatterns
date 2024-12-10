package code.cargocultprogramming;

public class OrderServiceExample {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);
        orderService.processOrder();
    }
}

class PaymentService {
    public void processPayment() {
        System.out.println("Processing payment...");
    }
}

class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processOrder() {
        System.out.println("Processing order...");
        paymentService.processPayment();
    }
}
