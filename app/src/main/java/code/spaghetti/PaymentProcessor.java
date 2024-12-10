package code.spaghetti;

interface Payment {
    void process();
}

class CreditCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing credit card payment...");
    }
}

class DebitCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing debit card payment...");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing PayPal payment...");
    }
}

class BitcoinPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing Bitcoin payment...");
    }
}

public class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.process();
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        Payment payment = new CreditCardPayment();
        processor.processPayment(payment);
    }
}
