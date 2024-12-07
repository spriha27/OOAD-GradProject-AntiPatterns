# Data Class

**AntiPattern Name:** Data Class\
**Also Known As:** Anemic Domain Model\
**Most Frequent Scale:** Class Level\
**Refactored Solution Name:** Rich Domain Model\
**Refactored Solution Type:** Refactoring Technique

## Explanation
A **Data Class** is an anti-pattern where a class is used primarily for storing data without any meaningful behavior. Such classes are often filled with getter and setter methods, but lack logic that operates on the data. This results in a lack of encapsulation and cohesive behavior, making the code less maintainable and harder to evolve. Data Classes typically exist in systems that do not properly utilize Object-Oriented Design principles.

## Real-World Example of Data Class
In many legacy enterprise applications, domain objects were used solely as data carriers, and the business logic was implemented separately in service classes. This led to weak encapsulation, a violation of the **Tell, Don’t Ask** principle, and highly procedural code.

## Examples
### 1. Plain Data Holder Class

In legacy systems, it is common to see data classes that hold fields with corresponding getters and setters but have no meaningful behavior.

**Example:**

Consider a `Customer` class that only holds data about a customer.

```java
public class Customer {
    private String name;
    private String email;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

**Problem**: The `Customer` class is just a data holder without any behavior, which means that the business logic related to a customer might be scattered across multiple service classes, leading to a loss of cohesion.

**Solution**: Move behavior related to the `Customer` class into the class itself, making it more cohesive.

**Solution Code:**

```java
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
}
```

**Benefit**: By adding behavior to the `Customer` class, it becomes more cohesive, and logic related to updating or validating a customer's data is encapsulated within the class itself.

### 2. Transaction Class Without Behavior

A class that is used solely for storing transaction data without any domain logic related to transactions.

**Example:**

Consider a `Transaction` class that only has fields and getters/setters.

```java
public class Transaction {
    private double amount;
    private String type;

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
```

**Problem**: The `Transaction` class lacks any meaningful business logic related to transactions, resulting in the logic being scattered across multiple classes.

**Solution**: Add methods to perform operations related to a transaction.

**Solution Code:**

```java
public class Transaction {
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() { return amount; }
    public String getType() { return type; }

    public boolean isCredit() {
        return "credit".equalsIgnoreCase(type);
    }

    public boolean isDebit() {
        return "debit".equalsIgnoreCase(type);
    }
}
```

**Benefit**: By adding behavior to the `Transaction` class, such as determining whether it is a credit or debit, the class becomes richer, and transaction-related logic is encapsulated within the class.

### 3. Product Class with Only Data Fields

A `Product` class that only has fields to store information about a product, with no associated behavior.

**Example:**

```java
public class Product {
    private String name;
    private double price;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
```

**Problem**: The `Product` class is a mere container of data with no meaningful behavior, resulting in business logic being implemented elsewhere.

**Solution**: Move behavior related to the `Product` class into the class itself.

**Solution Code:**

```java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public double applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }
        return price - (price * discountPercentage / 100);
    }
}
```

**Benefit**: By moving behavior, like applying a discount, into the `Product` class, we create a rich domain model where product-related logic is centralized, improving maintainability.

### 4. Anemic Employee Class

An `Employee` class that only has fields for storing employee data, but no behavior.

**Example:**

```java
public class Employee {
    private String name;
    private double salary;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
```

**Problem**: The `Employee` class is an anemic domain model, as it lacks behavior related to an employee, such as salary adjustment.

**Solution**: Add behavior related to an employee, such as giving a raise.

**Solution Code:**

```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void giveRaise(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Raise percentage must be positive");
        }
        this.salary += salary * percentage / 100;
    }
}
```

**Benefit**: By adding behavior like `giveRaise`, the `Employee` class becomes a richer domain object, encapsulating employee-related operations and adhering to object-oriented principles.

### 5. Invoice Class with No Behavior

An `Invoice` class that only stores data related to an invoice.

**Example:**

```java
public class Invoice {
    private double amount;
    private String customer;

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }
}
```

**Problem**: The `Invoice` class is a simple data holder with no behavior.

**Solution**: Add methods to perform operations on the invoice, such as calculating tax or marking it as paid.

**Solution Code:**

```java
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
}
```

**Benefit**: By adding behavior like `markAsPaid` and `calculateTax`, the `Invoice` class becomes more cohesive and encapsulates logic that is directly related to invoices, making the system more maintainable.

