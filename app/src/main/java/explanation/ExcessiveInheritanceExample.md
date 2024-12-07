# Excessive Use of Inheritance

**AntiPattern Name:** Excessive Use of Inheritance\
**Also Known As:** Deep Inheritance\
**Most Frequent Scale:** Class Hierarchy\
**Refactored Solution Name:** Composition Over Inheritance\
**Refactored Solution Type:** Design Pattern

## Explanation
Excessive use of inheritance occurs when developers create deep and complex inheritance hierarchies without considering simpler alternatives. This often leads to tight coupling between classes, where changes to a base class may propagate to many subclasses, making the system fragile and harder to maintain.

## Real-World Example of Excessive Inheritance
In the early versions of some frameworks, developers tried to model all possible relationships using inheritance, creating deep inheritance trees. This resulted in classes that were unnecessarily dependent on their parent classes, which in turn made it difficult to add new functionality without modifying several classes in the hierarchy.

## Examples
### 1. Deep Inheritance Tree

In larger codebases, it’s common to find deep inheritance trees where classes extend each other multiple levels deep. This leads to tight coupling, making it difficult to change the base classes without affecting all subclasses.

**Example:**

Consider a vehicle system where different types of vehicles are created through inheritance.

```java
public class Vehicle {
    public void startEngine() {
        // Engine starting logic
    }
}

public class Car extends Vehicle {
    public void enableAirConditioner() {
        // Air conditioner logic
    }
}

public class ElectricCar extends Car {
    public void chargeBattery() {
        // Charging logic
    }
}
```

**Problem**: The hierarchy is deep, and any change in `Vehicle` could impact both `Car` and `ElectricCar`, making maintenance cumbersome.

**Solution**: Refactor to use **composition** instead of inheritance, where `Vehicle` has separate classes for specific features like `AirConditioner` and `BatteryCharger`.

```java
public class Vehicle {
    private Engine engine;
    
    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public void startEngine() {
        engine.start();
    }
}

public class ElectricCar {
    private Vehicle vehicle;
    private BatteryCharger charger;

    public ElectricCar(Vehicle vehicle, BatteryCharger charger) {
        this.vehicle = vehicle;
        this.charger = charger;
    }

    public void startEngine() {
        vehicle.startEngine();
    }

    public void chargeBattery() {
        charger.charge();
    }
}
```

**Benefit**: This improves maintainability by decoupling features and avoiding unnecessary inheritance.

### 2. Inheritance for Shared Behavior

In some systems, developers use inheritance to share behavior between different classes, even when those classes don't perfectly fit into the hierarchy.

**Example:**

Consider an animal hierarchy where birds are modeled to inherit from `Animal`, but not all birds can fly.

```java
public class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
}

public class Bird extends Animal {
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```

**Problem**: `Penguin` inherits from `Bird`, but cannot fly. This violates the **Liskov Substitution Principle**.

**Solution**: Use **composition** to provide specific behaviors to animals instead of forcing all birds to inherit flying capabilities.

```java
public class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
}

public interface Flyable {
    void fly();
}

public class Bird extends Animal implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Penguin extends Animal {
    // Penguins do not implement Flyable
}
```

**Benefit**: This avoids forcing subclasses to inherit behavior that they cannot support, leading to a more flexible design.

### 3. Multiple Inheritance for Unrelated Features

When attempting to reuse code, developers sometimes try to inherit from multiple classes, which leads to complex and fragile designs.

**Example:**

Consider a multifunction device that tries to inherit from both `Printer` and `Scanner` classes.

```java
public class Printer {
    public void print() {
        System.out.println("Printing...");
    }
}

public class Scanner {
    public void scan() {
        System.out.println("Scanning...");
    }
}

public class MultiFunctionDevice extends Printer, Scanner { // Not allowed in Java
}
```

**Problem**: Java does not support multiple inheritance, and trying to inherit from multiple unrelated classes leads to complexity and ambiguity.

**Solution**: Use **composition** to combine functionalities.

```java
public class MultiFunctionDevice {
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionDevice(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void print() {
        printer.print();
    }

    public void scan() {
        scanner.scan();
    }
}
```

**Benefit**: Composition provides flexibility and avoids the complications of multiple inheritance.

### 4. Inheriting Utility Methods

Inheritance is sometimes misused to gain access to utility methods, which leads to inappropriate class hierarchies.

**Example:**

Consider a utility class that provides logging functionality.

```java
public class Utility {
    public static void log(String message) {
        System.out.println(message);
    }
}

public class Application extends Utility {
    // Inherits log method
}
```

**Problem**: Utility methods should not be inherited. It leads to misuse of inheritance and violates **Single Responsibility Principle**.

**Solution**: Use **composition** by calling the utility method directly.

```java
public class Application {
    public void performTask() {
        Utility.log("Task performed");
    }
}
```

**Benefit**: Avoids unnecessary inheritance and maintains a clear separation of concerns.

### 5. Deep Hierarchy for Role Specialization

In large systems, role specialization is often represented with deep inheritance hierarchies, making it difficult to manage.

**Example:**

Consider an employee hierarchy where different roles are modeled through inheritance.

```java
public class Employee {
    public void work() {
        System.out.println("Working...");
    }
}

public class Manager extends Employee {
    public void manage() {
        System.out.println("Managing...");
    }
}

public class Director extends Manager {
    public void strategize() {
        System.out.println("Strategizing...");
    }
}
```

**Problem**: A deep hierarchy for roles leads to rigid structures that are hard to extend.

**Solution**: Use **interfaces** to represent different responsibilities.

```java
public interface Workable {
    void work();
}

public interface Manageable {
    void manage();
}

public interface Strategizable {
    void strategize();
}

public class Employee implements Workable {
    @Override
    public void work() {
        System.out.println("Working...");
    }
}

public class Manager implements Workable, Manageable {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void manage() {
        System.out.println("Managing...");
    }
}

public class Director implements Workable, Manageable, Strategizable {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void manage() {
        System.out.println("Managing...");
    }

    @Override
    public void strategize() {
        System.out.println("Strategizing...");
    }
}
```

**Benefit**: This approach allows more flexibility and avoids deep inheritance trees.

