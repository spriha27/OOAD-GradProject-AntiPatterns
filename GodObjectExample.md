# God Objects and Violation of the Single Responsibility Principle (SRP)

**AntiPattern Name:** God Object\
**Also Known As:** Blob\
**Most Frequent Scale:** Class Level\
**Refactored Solution Name:** Extract Class\
**Refactored Solution Type:** Refactoring Technique

## Explanation
A **God Object** is an anti-pattern where a single class has far too many responsibilities. It violates the **Single Responsibility Principle** (SRP) and leads to a low level of cohesion. These classes typically grow over time, accumulating functionality, and making them difficult to maintain or test.

## Real-World Example of God Object
Large enterprise systems often have classes called `Manager` or `Handler` that contain hundreds of methods. These classes tend to handle everything from data access to business logic and even UI components, making it impossible to modify one part of the class without potentially breaking unrelated functionality.

## Examples
### 1. Overloaded Manager Class

In larger codebases, it’s common to find classes that accumulate multiple responsibilities, such as managing orders, notifications, and backups all in one place.

**Example:**

Consider an order management class that handles various responsibilities.

```java
public class OrderManager {
    public void createOrder() { /* Order creation logic */ }
    public void deleteOrder() { /* Order deletion logic */ }
    public void sendOrderNotification() { /* Notification logic */ }
    public void backupOrders() { /* Backup logic */ }
}
```

**Problem**: `OrderManager` handles order creation, deletion, notification, and backup, violating SRP.

**Solution**: Extract responsibilities into separate classes, such as `OrderService`, `NotificationService`, and `BackupService`.

```java
public class OrderService {
    public void createOrder() { /* Order creation logic */ }
    public void deleteOrder() { /* Order deletion logic */ }
}

public class NotificationService {
    public void sendOrderNotification() { /* Notification logic */ }
}

public class BackupService {
    public void backupOrders() { /* Backup logic */ }
}
```

**Benefit**: This promotes **separation of concerns** and makes each class easier to understand, modify, and test.

### 2. Centralized Controller Handling Multiple Responsibilities

In some applications, a centralized controller often grows to handle multiple unrelated responsibilities.

**Example:**

Consider an application controller that handles user input, business logic, and UI rendering.

```java
public class ApplicationController {
    public void handleUserInput() { /* Handle user input */ }
    public void processBusinessLogic() { /* Business logic */ }
    public void renderUI() { /* Render user interface */ }
}
```

**Problem**: `ApplicationController` is responsible for user input, business logic, and UI rendering, violating SRP.

**Solution**: Split the responsibilities into separate classes, each focused on a specific task.

```java
public class InputHandler {
    public void handleUserInput() { /* Handle user input */ }
}

public class BusinessLogicProcessor {
    public void processBusinessLogic() { /* Business logic */ }
}

public class UIController {
    public void renderUI() { /* Render user interface */ }
}
```

**Benefit**: Each class now has a single responsibility, making the system more modular and easier to maintain.

### 3. Monolithic DataManager Class

In larger systems, data management often ends up in a single monolithic class that handles reading, writing, validation, and backup.

**Example:**

Consider a `DataManager` class that handles multiple data-related operations.

```java
public class DataManager {
    public void readData() { /* Read data logic */ }
    public void writeData() { /* Write data logic */ }
    public void validateData() { /* Validate data logic */ }
    public void backupData() { /* Backup data logic */ }
}
```

**Problem**: `DataManager` has multiple responsibilities, including reading, writing, validation, and backup.

**Solution**: Split into `DataReader`, `DataWriter`, `DataValidator`, and `DataBackup` classes.

```java
public class DataReader {
    public void readData() { /* Read data logic */ }
}

public class DataWriter {
    public void writeData() { /* Write data logic */ }
}

public class DataValidator {
    public void validateData() { /* Validate data logic */ }
}

public class DataBackup {
    public void backupData() { /* Backup data logic */ }
}
```

**Benefit**: Improved separation of concerns and easier maintenance.

### 4. All-in-One Utility Class

Utility classes often accumulate a wide variety of unrelated methods, leading to a God Object.

**Example:**

Consider a utility class that provides methods for parsing data, sending emails, and generating reports.

```java
public class Utility {
    public void parseData() { /* Data parsing logic */ }
    public void sendEmail() { /* Email sending logic */ }
    public void generateReport() { /* Report generation logic */ }
}
```

**Problem**: The `Utility` class has multiple unrelated responsibilities, making it a God Object.

**Solution**: Extract the methods into separate classes, each with a specific responsibility.

```java
public class DataParser {
    public void parseData() { /* Data parsing logic */ }
}

public class EmailService {
    public void sendEmail() { /* Email sending logic */ }
}

public class ReportGenerator {
    public void generateReport() { /* Report generation logic */ }
}
```

**Benefit**: Each class has a clear responsibility, improving modularity.

### 5. Overloaded ShoppingCart Class

Shopping cart classes often grow to include multiple responsibilities, such as adding items, calculating totals, applying discounts, and managing checkout.

**Example:**

Consider a `ShoppingCart` class that handles multiple aspects of the shopping process.

```java
public class ShoppingCart {
    public void addItem() { /* Add item logic */ }
    public void removeItem() { /* Remove item logic */ }
    public void calculateTotal() { /* Total calculation logic */ }
    public void applyDiscount() { /* Discount logic */ }
    public void checkout() { /* Checkout logic */ }
}
```

**Problem**: `ShoppingCart` handles adding items, calculating totals, discounts, and checkout, violating SRP.

**Solution**: Extract responsibilities into separate classes like `CartManager`, `PriceCalculator`, and `CheckoutService`.

```java
public class CartManager {
    public void addItem() { /* Add item logic */ }
    public void removeItem() { /* Remove item logic */ }
}

public class PriceCalculator {
    public void calculateTotal() { /* Total calculation logic */ }
    public void applyDiscount() { /* Discount logic */ }
}

public class CheckoutService {
    public void checkout() { /* Checkout logic */ }
}
```

**Benefit**: Each class has a single responsibility, making the system easier to maintain and extend.

