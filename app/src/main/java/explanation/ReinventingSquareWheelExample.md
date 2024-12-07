# Reinventing the Square Wheel

**AntiPattern Name:** Reinventing the Square Wheel\
**Also Known As:** Reinventing the Wheel Poorly\
**Most Frequent Scale:** Project or System Level\
**Refactored Solution Name:** Leverage Existing Solutions\
**Refactored Solution Type:** Reuse of Existing Libraries and Patterns

## Explanation
**Reinventing the Square Wheel** is an anti-pattern where developers create custom solutions for problems that have already been solved effectively by well-established, existing tools or libraries. Instead of using the best practices or leveraging existing components, they reinvent functionality with an inferior, inefficient, or less-tested solution. This often leads to wasted effort, bugs, and maintainability issues.

## Real-World Example of Reinventing the Square Wheel
A classic example is building a custom logging system when well-established libraries like **Log4j** or **SLF4J** exist. Many developers attempt to write their own logging systems, but the results are often error-prone, lack flexibility, and miss essential features such as log rotation, multi-level logging, or integration with monitoring tools.

## Examples

### 1. Custom Authentication System

A developer attempts to create a custom authentication and authorization system rather than using well-established tools like **OAuth2** or **OpenID Connect**.

**Example:**

Consider an in-house authentication system where usernames and passwords are manually checked.

```java
public class AuthService {
    public boolean authenticate(String username, String password) {
        // Custom logic to verify username and password
        if (username.equals("admin") && password.equals("password123")) {
            return true;
        }
        return false;
    }
}
```

**Problem**: Custom authentication systems are prone to vulnerabilities like **SQL injection**, **insecure password storage**, and poor session management. Maintaining a secure and effective authentication system requires a deep understanding of security, which is often neglected.

**Solution**: Use a well-established library such as **Spring Security** to handle authentication and authorization.

**Solution Code:**

```java
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}password123").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
```

**Benefit**: Using a proven framework like **Spring Security** reduces the risk of security vulnerabilities and ensures that the system benefits from community-tested, up-to-date security standards.

### 2. Custom Collection Classes

A developer writes custom collection classes instead of using the well-tested **Java Collections Framework**.

**Example:**

Consider a custom implementation of a **resizable array** to store elements.

```java
public class MyArrayList {
    private int[] data;
    private int size;

    public MyArrayList() {
        data = new int[10];
        size = 0;
    }

    public void add(int value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }

    private void resize() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
```

**Problem**: Custom collection classes are often inefficient and lack the robustness, performance optimization, and functionality of standard libraries.

**Solution**: Use the **ArrayList** class from the **Java Collections Framework**, which is highly optimized and well-tested.

**Solution Code:**

```java
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
    }
}
```

**Benefit**: Using the Java Collections Framework reduces code complexity, improves performance, and ensures a well-tested, efficient implementation.

### 3. Custom Logging System

A developer builds a custom logging system rather than using an existing logging framework like **Log4j** or **SLF4J**.

**Example:**

Consider a custom logger that writes logs to a file.

```java
public class CustomLogger {
    public void log(String message) {
        try (FileWriter writer = new FileWriter("app.log", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Problem**: The custom logger lacks essential features like **log rotation**, **log levels**, and **thread safety**. Reimplementing these features would require significant effort and still be less robust compared to established libraries.

**Solution**: Use **SLF4J** and **Logback** for logging.

**Solution Code:**

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {
    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {
        logger.info("This is an informational message.");
    }
}
```

**Benefit**: Established logging frameworks provide a wealth of features, such as log levels, formatting, rotation, and integration with other systems, without the need to reimplement these capabilities.

### 4. Custom Date and Time Utilities

A developer creates custom classes for date and time management instead of using standard libraries like **java.time** or **Joda-Time**.

**Example:**

Consider a class that calculates the difference between two dates.

```java
public class DateUtil {
    public static int daysBetween(Date date1, Date date2) {
        long difference = date2.getTime() - date1.getTime();
        return (int) (difference / (1000 * 60 * 60 * 24));
    }
}
```

**Problem**: Manually calculating the difference between dates can lead to errors, especially when accounting for daylight saving time, leap years, and time zones.

**Solution**: Use **java.time** from Java 8 or later, which provides comprehensive date and time handling.

**Solution Code:**

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Example {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2022, 1, 10);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Days between: " + daysBetween);
    }
}
```

**Benefit**: Using **java.time** ensures correct handling of dates, time zones, and leap years, reducing the chance of bugs and improving maintainability.

### 5. Custom Thread Pool Implementation

A developer writes a custom thread pool instead of using **java.util.concurrent**.

**Example:**

Consider a custom implementation of a thread pool to manage background tasks.

```java
public class CustomThreadPool {
    private final List<Thread> threads = new ArrayList<>();

    public CustomThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    // Custom logic to manage tasks
                }
            });
            threads.add(thread);
            thread.start();
        }
    }
}
```

**Problem**: Implementing a custom thread pool is complex and error-prone. It lacks features like **task queuing**, **thread reuse**, and **graceful shutdown**.

**Solution**: Use the **ExecutorService** from **java.util.concurrent**.

**Solution Code:**

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(() -> System.out.println("Task executed"));
        executor.shutdown();
    }
}
```

**Benefit**: Using **ExecutorService** provides a robust, well-tested implementation with advanced features like thread reuse, graceful shutdown, and error handling, reducing development effort and improving system stability.

