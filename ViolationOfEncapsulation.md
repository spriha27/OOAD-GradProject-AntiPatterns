# Violation of Encapsulation

**AntiPattern Name:** Violation of Encapsulation\
**Also Known As:** Data Exposure\
**Most Frequent Scale:** Attribute Level\
**Refactored Solution Name:** Encapsulation with Access Control\
**Refactored Solution Type:** Refactoring Technique

## Explanation

Encapsulation is a fundamental principle of object-oriented programming that helps protect the internal state of an object by providing controlled access through methods. Violating encapsulation usually involves making class fields public or providing direct access to internal data, which increases the risk of unintended modifications and makes it harder to maintain consistency.

## Real-World Example of Violation of Encapsulation

In early versions of some Java libraries, classes would expose their fields directly to allow easier access. However, this led to unintended changes, causing difficult-to-find bugs and making it challenging to update the internal implementation.

## Examples

### 1. Public Fields

In some applications, class fields are made public to allow easy access. This violates encapsulation, as there is no control over how these fields are modified.

**Example:**

Consider a User class with public fields.
```
public class User {
    public String name;
    public int age;
}
```
Problem: The fields name and age are directly accessible, allowing uncontrolled modification.

Solution: Make fields private and provide getters and setters with validation if needed.
```
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
```
Benefit: This enforces data integrity and allows validation logic to be added easily.

### 2. Providing Direct Access to Collections

Providing direct access to collections in a class exposes the internal data and allows external modifications without any control.

**Example:**

Consider a Team class with a public list of members.
```
public class Team {
    public List<String> members;
}
```
Problem: The members list is directly accessible, allowing uncontrolled modifications.

Solution: Use encapsulation to provide controlled access to the list.
```
public class Team {
    private List<String> members = new ArrayList<>();

    public List<String> getMembers() {
        return new ArrayList<>(members); // Return a copy to prevent modification
    }

    public void addMember(String member) {
        members.add(member);
    }
}
```
Benefit: This prevents external classes from modifying the list directly, maintaining better control over the object's state.

### 3. Public Array Fields

Arrays are mutable, and providing direct access to them can lead to unintended modifications.

**Example:**

Consider a Data class with a public array field.
```
public class Data {
    public int[] values;
}
```
Problem: The array values is public, allowing direct modification.

Solution: Make the array private and provide controlled access.
```
public class Data {
    private int[] values;

    public int[] getValues() {
        return values.clone();
    }

    public void setValues(int[] values) {
        this.values = values.clone();
    }
}
```
Benefit: Prevents unintended modifications and ensures encapsulation.

### 4. Direct Access to Object References

Providing direct access to object references can lead to unintended side effects when the object state is modified externally.

**Example:**

Consider a Library class with a public reference to a Book object.
```
public class Library {
    public Book book;
}
```
Problem: The book reference is public, allowing external classes to modify it directly.

Solution: Make the reference private and provide controlled access.
```
public class Library {
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
```
Benefit: Provides controlled access and preserves object integrity.

### 5. Inadequate Access Control for Sensitive Data

Sensitive data should not be exposed directly, as it can lead to security vulnerabilities and unintended modifications.

**Example:**

Consider an Account class with a public balance field.
```
public class Account {
    public double balance;
}
```
Problem: The balance field is public, which is inappropriate for sensitive data.

Solution: Use proper encapsulation with validation.
```
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
```
Benefit: Sensitive data is protected, and access is controlled.

