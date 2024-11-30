# Golden Hammer

**AntiPattern Name:** Golden Hammer\
**Also Known As:** Overuse of a Familiar Tool\
**Most Frequent Scale:** System or Team Level\
**Refactored Solution Name:** Context-Specific Design\
**Refactored Solution Type:** Architectural and Design Refactoring

## Explanation
The **Golden Hammer** is an anti-pattern where a single technology, tool, or design approach is applied universally to solve all problems, regardless of whether it is the best solution for the specific context. This often occurs when developers are comfortable with a particular tool or pattern and try to use it in every situation, leading to suboptimal design and performance issues. The phrase "When all you have is a hammer, everything looks like a nail" aptly describes this anti-pattern.

## Real-World Example of Golden Hammer
A common real-world example of the Golden Hammer is the overuse of **relational databases** for every kind of data storage problem. While relational databases are powerful and versatile, they are not always the best solution for storing hierarchical, graph-based, or unstructured data. Teams comfortable with SQL often force-fit all data models into relational schemas, leading to complex joins, scalability problems, and performance issues.

## Examples
### 1. Overuse of Relational Databases

Relational databases are often used as the default choice, even when other database solutions would be better suited for the use case.

**Example:**

Consider a system that requires storage of hierarchical data, such as an organizational structure.

```sql
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    manager_id INT,
    FOREIGN KEY (manager_id) REFERENCES Employee(id)
);
```

**Problem**: Using a relational database to model hierarchical data can lead to complex and inefficient queries. Retrieving the entire hierarchy requires recursive joins, which can be cumbersome and perform poorly for large data sets.

**Solution**: Use a **graph database** to store and query hierarchical relationships more efficiently.

**Solution Code:**

```cypher
CREATE (john:Employee {name: 'John'})
CREATE (sarah:Employee {name: 'Sarah'})
CREATE (michael:Employee {name: 'Michael'})

CREATE (john)-[:MANAGES]->(sarah)
CREATE (sarah)-[:MANAGES]->(michael)
```

**Benefit**: By using a graph database, queries to find relationships (e.g., managers and subordinates) are simpler and more efficient, leading to improved performance and maintainability.

### 2. Overuse of Design Patterns

Sometimes, developers fall in love with a particular design pattern and try to apply it everywhere, even where it is not appropriate.

**Example:**

Consider using the **Singleton pattern** for every service class in an application.

```java
public class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
```

**Problem**: Applying the Singleton pattern universally can lead to tight coupling, issues with unit testing, and problems when multiple instances are needed (e.g., different configurations for different environments).

**Solution**: Use dependency injection to manage object creation, allowing flexibility in the lifecycle and configuration of objects.

**Solution Code:**

```java
public class Logger {
    public void log(String message) {
        System.out.println(message);
    }
}

public class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void run() {
        logger.log("Application is running");
    }
}
```

**Benefit**: Dependency injection makes the system more flexible and testable by allowing different configurations or mock implementations to be used without changing the core logic.

### 3. Overuse of REST APIs

REST APIs are often used as the default approach for any kind of system integration, even when they are not the best choice.

**Example:**

Consider a real-time chat application where REST APIs are used to send and receive messages.

```java
// REST endpoint for sending a message
@PostMapping("/sendMessage")
public ResponseEntity<Void> sendMessage(@RequestBody Message message) {
    chatService.sendMessage(message);
    return ResponseEntity.ok().build();
}

// REST endpoint for receiving messages
@GetMapping("/receiveMessages")
public List<Message> receiveMessages() {
    return chatService.getMessages();
}
```

**Problem**: REST APIs are not suitable for real-time communication, as they rely on polling or frequent requests, leading to increased latency and network overhead.

**Solution**: Use **WebSockets** for real-time communication, which allows for bi-directional messaging with low latency.

**Solution Code:**

```java
@ServerEndpoint("/chat")
public class ChatEndpoint {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // Broadcast message to all clients
        session.getOpenSessions().forEach(s -> {
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Disconnected: " + session.getId());
    }
}
```

**Benefit**: WebSockets provide a more efficient way to handle real-time communication, reducing latency and improving the user experience for chat applications.

### 4. Overuse of Object-Oriented Programming (OOP)

Sometimes, OOP concepts like inheritance are overused even when a simpler, more appropriate solution could be applied.

**Example:**

Consider a scenario where a deep inheritance hierarchy is used for different types of documents.

```java
public class Document {}
public class TextDocument extends Document {}
public class SpreadsheetDocument extends Document {}
public class PdfDocument extends Document {}
```

**Problem**: This approach can lead to a rigid class hierarchy, making it difficult to adapt to changes or add new document types without modifying existing code.

**Solution**: Use **composition** instead of inheritance, allowing flexibility in document behavior.

**Solution Code:**

```java
public interface Document {
    void open();
}

public class TextDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening text document");
    }
}

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }
}

public class DocumentViewer {
    public void viewDocument(Document document) {
        document.open();
    }
}
```

**Benefit**: Using composition rather than inheritance makes the code more flexible, easier to extend, and adheres to the **Open-Closed Principle**.

### 5. Overuse of Microservices

Microservices have gained popularity as an architectural pattern, but they are sometimes used even when a monolith would be more appropriate.

**Example:**

Consider an application that manages a small e-commerce store with a few dozen users.

**Problem**: Breaking the application into multiple microservices adds unnecessary complexity, such as managing inter-service communication, distributed transactions, and deployment. For a small application, this overhead outweighs the benefits.

**Solution**: Use a **modular monolith** where the codebase is logically divided into modules, but deployed as a single unit.

**Solution Code:**

```java
public class ECommerceApplication {
    private ProductService productService;
    private OrderService orderService;

    public ECommerceApplication(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public void run() {
        productService.listProducts();
        orderService.placeOrder("Product123");
    }
}
```

**Benefit**: A modular monolith allows for clean separation of concerns and code organization while keeping deployment and operations simple, making it a better fit for small to medium-sized applications.

