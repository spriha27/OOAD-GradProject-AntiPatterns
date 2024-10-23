# Spaghetti Code

**AntiPattern Name:** Spaghetti Code

**Also Known As:** Tangled Code, Messy Code

**Most Frequent Scale:** Method or Class Level (can also extend to System Level in larger codebases)

**Refactored Solution Name:** Modularization

**Refactored Solution Type:** Refactoring with Proper Separation of Concerns (SoC), Increased Cohesion, and Decreased Coupling through techniques like Decomposition, Encapsulation, and Object-Oriented Design Principles

## Explanation

Spaghetti code refers to unstructured and hard-to-maintain code, typically resulting from poor design decisions, lack of proper architecture, and insufficient use of OOAD principles.

## Real-World example of Spaghetti Code

### NASA’s Space Shuttle Software

* The software used for the Space Shuttle was initially plagued by spaghetti code problems due to the complexity of its requirements. NASA had to put in a massive effort to rewrite and thoroughly test the code to ensure it was reliable enough for space missions.
* During early development, the tight coupling and lack of a modular structure made it difficult to adapt the software to changes or new requirements. Eventually, NASA moved to extremely rigorous coding standards, including breaking down complex modules, which led to the legendary reliability of the final system.

## Examples

### 1. Lack of Separation of Concerns

All logic—user interface, business logic, and data handling—are mixed in a single class, making it hard to maintain or modify parts independently.

```public class OrderProcessing {
    public void processOrder() {
        // Input validation
        System.out.println("Validating order...");
        
        // Order processing logic
        System.out.println("Processing order...");

        // Update database
        System.out.println("Updating database...");

        // Send notification
        System.out.println("Sending confirmation email...");
    }
}
```

Problem: Multiple responsibilities are mixed into a single method. This method not only processes orders, but also handles input validation, data updates, and notifications, violating the Single Responsibility Principle.

Solution: Introduce multiple classes with distinct responsibilities to adhere to the Single Responsibility Principle. Each aspect of the order processing is handled by a different class.

```public class OrderValidator {
    public void validateOrder(Order order) {
        System.out.println("Validating order...");
        // Validation logic here
    }
}

public class OrderProcessor {
    public void processOrder(Order order) {
        System.out.println("Processing order...");
        // Order processing logic here
    }
}

public class OrderRepository {
    public void updateOrderInDatabase(Order order) {
        System.out.println("Updating database...");
        // Database update logic here
    }
}

public class NotificationService {
    public void sendConfirmation(Order order) {
        System.out.println("Sending confirmation email...");
        // Notification logic here
    }
}

// Refactored main workflow
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
}
```

### 2. Excessive Use of Conditional Statements

Deeply nested if-else and switch statements scattered throughout the codebase, making it difficult to follow the control flow.

```public class PaymentProcessor {
    public void processPayment(String paymentType) {
        if (paymentType.equals("credit_card")) {
            // Process credit card payment
        } else if (paymentType.equals("debit_card")) {
            // Process debit card payment
        } else if (paymentType.equals("paypal")) {
            // Process PayPal payment
        } else if (paymentType.equals("bitcoin")) {
            // Process Bitcoin payment
        } else {
            // Handle unknown payment type
        }
    }
}
```

Problem: Adding new payment methods would require modifying this method, violating the Open-Closed Principle. It’s better to use polymorphism with different payment classes.

Solution: Use an interface (Payment) and different implementations for each payment type. The PaymentProcessor class no longer needs to handle multiple conditional branches; it simply relies on polymorphism.

```public interface Payment {
    void process();
}

public class CreditCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing credit card payment...");
    }
}

public class DebitCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing debit card payment...");
    }
}

public class PayPalPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing PayPal payment...");
    }
}

public class BitcoinPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing Bitcoin payment...");
    }
}

public class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.process();
    }
}
```

### 3. Poor Class Design and Low Cohesion

One class does too many things, leading to low cohesion, making it challenging to understand what the class is actually responsible for.

```public class UserManager {
    public void createUser() {
        // Logic to create a user
    }

    public void deleteUser() {
        // Logic to delete a user
    }

    public void sendNotification(String message) {
        // Logic to send a notification
    }

    public void backupDatabase() {
        // Logic to back up the database
    }
}
```

Problem: UserManager is handling unrelated tasks like user operations, notifications, and backups, which results in low cohesion.

Solution: Decompose the calculation into smaller methods with specific responsibilities. Avoid using a global variable (result), and instead use local variables to keep the state scoped and manageable.

```public class Calculator {
    public int calculateSum(int limit) {
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += i;
        }
        return sum;
    }

    public int calculateProduct(int limit) {
        int product = 1;
        for (int j = 1; j < limit; j++) {
            product *= j;
        }
        return product;
    }

    public int calculate() {
        int sum = calculateSum(10);
        int product = calculateProduct(5);
        return sum * product;
    }
}
```

### 4. Long Methods and Overuse of Global Variables

A method becomes extremely long with multiple nested loops, and the use of global variables makes tracking the flow of data very difficult.

``` public class Calculator {
    public static int result = 0;

    public void calculate() {
        for (int i = 0; i < 10; i++) {
            // Some calculation
            result += i;
            for (int j = 0; j < 5; j++) {
                result *= j;
            }
        }

        // Continue with more complex calculations
        // No clear separation of tasks
    }
}
```

Problem: The method does too many things and uses a global variable (result), making it hard to determine which parts of the code are responsible for changes, leading to unpredictable side effects.

Solution: Introduce an interface (Helper) to break the direct dependency between ClassA and ClassB. Now, ClassA depends on an abstraction (Helper) rather than ClassB, and ClassB implements Helper.

```public interface Helper {
    void help();
}

public class ClassA {
    private Helper helper;

    public ClassA(Helper helper) {
        this.helper = helper;
    }

    public void doSomething() {
        helper.help();
    }
}

public class ClassB implements Helper {
    @Override
    public void help() {
        System.out.println("Helping ClassA...");
    }
}
```

### 5. Circular Dependencies

Classes depending on each other excessively, creating tangled and hard-to-follow relationships.

```
public class ClassA {
    private ClassB b;

    public ClassA(ClassB b) {
        this.b = b;
    }

    public void doSomething() {
        b.helpA();
    }
}

public class ClassB {
    private ClassA a;

    public ClassB(ClassA a) {
        this.a = a;
    }

    public void helpA() {
        a.doSomething();
    }
}
```

Problem: ClassA and ClassB are tightly coupled and depend on each other, creating a circular dependency, making it difficult to modify or reuse these classes independently.

### 6. Hardcoded Values and Deep Nesting

Using hardcoded values and having deeply nested control statements that are difficult to read and understand.

```public class DiscountCalculator {
    public double calculateDiscount(String customerType, int purchaseAmount) {
        if (customerType.equals("regular")) {
            if (purchaseAmount > 100) {
                return 10;
            } else {
                return 5;
            }
        } else if (customerType.equals("vip")) {
            if (purchaseAmount > 500) {
                return 20;
            } else {
                return 15;
            }
        } else {
            return 0;
        }
    }
}
```

Problem: Deep nesting and hardcoded values make the logic confusing and difficult to maintain. Adding new customer types requires modifying the same code, making it prone to errors.
