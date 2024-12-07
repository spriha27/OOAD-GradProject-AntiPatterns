package java.code.primitiveobsession.customer;

public class Customer {
    private CustomerID customerId;

    public Customer(CustomerID customerId) {
        this.customerId = customerId;
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public static void main(String[] args) {
        CustomerID customerId = CustomerID.generate();
        Customer customer = new Customer(customerId);
        System.out.println("Customer ID: " + customer.getCustomerId().getValue());
    }
}