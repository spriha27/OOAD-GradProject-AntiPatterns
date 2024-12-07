package java.code.lavaflow;

public class PaymentHandler {
    public void handlePayment(Payment payment) {
        // Unified payment handling logic
        payment.process();
    }

    public static void main(String[] args) {
        Payment creditPayment = new CreditCardPayment();
        PaymentHandler handler = new PaymentHandler();
        handler.handlePayment(creditPayment);
    }
}

// Payment Interface
interface Payment {
    void process();
}

// Specific Payment Implementations
class CreditCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing credit card payment...");
    }
}

class PaypalPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing PayPal payment...");
    }
}

class BankTransferPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing bank transfer payment...");
    }
}