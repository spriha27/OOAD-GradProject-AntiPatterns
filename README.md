
# OOAD GradProject - AntiPatterns

**Team Members:** Spriha Mandal, Arjyahi Bhattacharya, Arunava Ghosh

This project showcases various **Object-Oriented Design Anti-Patterns**, their characteristics, and examples. It's an educational tool designed to help developers understand common pitfalls in OOAD and how to avoid them.

## Features

- Examples of common OOAD anti-patterns.
- Illustrations of the impact of these patterns on maintainability, readability, and scalability.
- Code snippets showcasing how these anti-patterns manifest.

## Prerequisites

Ensure you have the following installed:

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Gradle 8.11.1](https://gradle.org/releases/)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/spriha27/OOAD-GradProject-AntiPatterns.git
   cd OOAD-GradProject-AntiPatterns
   ```

2. Build the project:
   ```bash
   ./gradlew clean build
   ```

## Directory Structure and Running Specific Anti-Patterns

Each anti-pattern example is located under `src/main/java/code/<anti-pattern-name>`. Some anti-patterns have standalone Java files, while others are organized into subdirectories. Follow the instructions below to run specific examples:

### Cargo Cult Programming
Path: `src/main/java/code/cargocultprogramming/`

- Examples: `NetworkConfigExample`, `OrderServiceExample`, `TryCatchExample`
- Run:
  ```bash
  java -cp build/libs/app.jar code.cargocultprogramming.<ExampleName>
  ```

### Data Class
Path: `src/main/java/code/dataclass/`

- Examples: `Transaction`, `Product`, `Invoice`, `Employee`, `Customer`
- Run:
  ```bash
  java -cp build/libs/app.jar code.dataclass.<ExampleName>
  ```

### Excessive Inheritance
Path: `src/main/java/code/excessiveinheritance/`

- Examples: `UtilityExample`, `MultiFunctionDevice`, `EmployeeExample`, `ElectricCar`, `BirdExample`
- Run:
  ```bash
  java -cp build/libs/app.jar code.excessiveinheritance.<ExampleName>
  ```

### God Object
Path: `src/main/java/code/godobject/`

- Subfolders:
  - `applicationcontroller`
  - `datamanager`
  - `ordermanager`
  - `shoppingcart`
  - `utility`
- Examples: `UtilityMain` (in `utility` folder)
- Run:
  ```bash
  java -cp build/libs/app.jar code.godobject.utility.UtilityMain
  ```

### Golden Hammer
Path: `src/main/java/code/goldenhammer/`


- Subfolders:
  - `oopoveruse`
  - `product`
  - `singleton`

- Examples: `singleton.Application`, `product.ECommerceApplication`, `oopoveruse.DocumentViewer`
- Run:
  ```bash
  java -cp build/libs/app.jar code.goldenhammer.<ExampleName>
  ```

### Lava Flow
Path: `src/main/java/code/lavaflow/`

- Examples: `UserAccount`, `RequestProcessor`, `PaymentHandler`, `NewProcessor`
- Run:
  ```bash
  java -cp build/libs/app.jar code.lavaflow.<ExampleName>
  ```

### Overcomplicated Object Hierarchies
Path: `src/main/java/code/overcomplicatedobject/`

- Examples: `Shape`, `Product`, `Car`, `AnimalSound`, `Animal`
- Run:
  ```bash
  java -cp build/libs/app.jar code.overcomplicatedobject.<ExampleName>
  ```

### Primitive Obsession
Path: `src/main/java/code/primitiveobsession/`

- Subfolders:
  - `useremail`
  - `productmoney`
  - `customer`
  - `contactphone`
- Examples: `User`, `Product`, `Customer`, `Contact`
- Run:
  ```bash
  java -cp build/libs/app.jar code.primitiveobsession.<ExampleName>
  ```

### Spaghetti Code
Path: `src/main/java/code/spaghetti/`

- Examples: `UserManagement`, `PaymentProcessor`, `OrderService`, `DiscountCalculator`, `Calculator`
- Run:
  ```bash
  java -cp build/libs/app.jar code.spaghetti.<ExampleName>
  ```

### Reinventing the Square Wheel
Path: `src/main/java/code/squarewheel/`

- Examples: `ThreadPoolExample`, `LoggingExample`, `DateExample`, `ArrayListExample`
- Run:
  ```bash
  java -cp build/libs/app.jar code.squarewheel.<ExampleName>
  ```

### Violation of Encapsulation
Path: `src/main/java/code/violationofencapsulation/`

- Examples: Specific examples are located directly in the folder.
- Run:
  ```bash
  java -cp build/libs/app.jar code.violationofencapsulation.<ExampleName>
  ```

---

Replace `<ExampleName>` with the class name you want to run. Each anti-pattern contains explanatory comments within the code for better understanding.