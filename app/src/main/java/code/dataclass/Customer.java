package java.code.dataclass;

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    public void updateEmail(String newEmail) {
        if (isValidEmail(newEmail)) {
            this.email = newEmail;
        }
    }

    private boolean isValidEmail(String email) {
        return email.contains("@"); // Simplified validation
    }

    public static void main(String[] args) {
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());

        customer.updateEmail("new.email@example.com");
        System.out.println("Updated Email: " + customer.getEmail());
    }
}