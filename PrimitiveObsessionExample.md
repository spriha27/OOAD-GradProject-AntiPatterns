# Primitive Obsession

**AntiPattern Name:** Primitive Obsession\
**Also Known As:** Primitive Type Overuse\
**Most Frequent Scale:** Class Level\
**Refactored Solution Name:** Replace Primitives with Domain-Specific Types\
**Refactored Solution Type:** Refactoring Technique

## Explanation
**Primitive Obsession** occurs when developers use primitive types (e.g., strings, integers) to represent concepts that could be better encapsulated in their own classes. This leads to a lack of clarity, validation logic scattered throughout the code, and a failure to properly model the domain. By creating domain-specific types, you can add behavior directly related to that type, leading to a more expressive and maintainable codebase.

## Real-World Example of Primitive Obsession
In many enterprise applications, strings or integers are often used to represent complex concepts like **addresses, currencies, or email addresses**. This results in duplicated validation and business logic throughout the system, rather than encapsulating it in a domain-specific class.

## Examples
### 1. Using Strings for Email Addresses

A common example of Primitive Obsession is using a `String` to represent an email address.

**Example:**

```java
public class User {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }
}
```

**Problem**: The validation logic for an email address is part of the `User` class. If email addresses are used elsewhere in the system, the validation logic may be duplicated in multiple places.

**Solution**: Create an `Email` class that encapsulates the email validation logic.

**Solution Code:**

```java
public class Email {
    private String value;

    public Email(String value) {
        if (!value.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public class User {
    private Email email;

    public User(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
```

**Benefit**: The validation logic is now encapsulated in the `Email` class, ensuring that all email addresses in the system are validated consistently.

### 2. Using Integers for Monetary Values

Another example of Primitive Obsession is using an `int` or `double` to represent monetary values.

**Example:**

```java
public class Product {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
}
```

**Problem**: Monetary values are represented using primitive types (`double`), which do not inherently provide any currency-specific behavior or prevent logical errors like incorrect rounding.

**Solution**: Create a `Money` class that encapsulates the price and provides additional behavior.

**Solution Code:**

```java
import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;

    public Money(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

public class Product {
    private Money price;

    public Product(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}
```

**Benefit**: The `Money` class provides better encapsulation and allows for additional methods, such as currency conversion or arithmetic operations, making the code more expressive and robust.

### 3. Using Strings for Phone Numbers

Using `String` to represent phone numbers can lead to scattered validation logic and inconsistent representations.

**Example:**

```java
public class Contact {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }
}
```

**Problem**: The validation logic for phone numbers is embedded in the `Contact` class, leading to potential duplication if phone numbers are used in other places.

**Solution**: Create a `PhoneNumber` class that encapsulates the phone number validation logic.

**Solution Code:**

```java
public class PhoneNumber {
    private String value;

    public PhoneNumber(String value) {
        if (!value.matches("\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public class Contact {
    private PhoneNumber phoneNumber;

    public Contact(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
```

**Benefit**: The `PhoneNumber` class centralizes validation logic, making the code more maintainable and ensuring consistent handling of
