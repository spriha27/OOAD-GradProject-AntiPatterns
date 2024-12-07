package java.code.primitiveobsession.customer;

import java.util.UUID;

public class CustomerID {
    private String value;

    public CustomerID(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }
        this.value = value;
    }

    public static CustomerID generate() {
        return new CustomerID(UUID.randomUUID().toString());
    }

    public String getValue() {
        return value;
    }
}