package java.code.spaghetti;

public class OrderService {
    private OrderValidator validator = new OrderValidator();
    private OrderProcessor processor = new OrderProcessor();
    private OrderRepository repository = new OrderRepository();
    private NotificationService notificationService = new NotificationService();

    public void processOrder(Order order) {
        validator.validateOrder(order);
        processor.processOrder(order);
        repository.updateOrderInDatabase(order);
        notificationService.sendConfirmation(order);
    }

    public static void main(String[] args) {
        Order order = new Order();
        OrderService service = new OrderService();
        service.processOrder(order);
    }
}

class Order {
    // Order fields and methods
}

class OrderValidator {
    public void validateOrder(Order order) {
        System.out.println("Validating order...");
    }
}

class OrderProcessor {
    public void processOrder(Order order) {
        System.out.println("Processing order...");
    }
}

class OrderRepository {
    public void updateOrderInDatabase(Order order) {
        System.out.println("Updating database...");
    }
}

class NotificationService {
    public void sendConfirmation(Order order) {
        System.out.println("Sending confirmation email...");
    }
}