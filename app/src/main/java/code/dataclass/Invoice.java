package code.dataclass;

public class Invoice {
    private double amount;
    private String customer;
    private boolean paid;

    public Invoice(double amount, String customer) {
        this.amount = amount;
        this.customer = customer;
        this.paid = false;
    }

    public double getAmount() { return amount; }
    public String getCustomer() { return customer; }
    public boolean isPaid() { return paid; }

    public void markAsPaid() {
        this.paid = true;
    }

    public double calculateTax(double taxRate) {
        return amount * taxRate / 100;
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice(200.0, "Acme Corp");
        System.out.println("Customer: " + invoice.getCustomer());
        System.out.println("Amount: $" + invoice.getAmount());
        System.out.println("Paid: " + invoice.isPaid());

        invoice.markAsPaid();
        System.out.println("Paid: " + invoice.isPaid());

        double tax = invoice.calculateTax(5.0);
        System.out.println("Tax: $" + tax);
    }
}