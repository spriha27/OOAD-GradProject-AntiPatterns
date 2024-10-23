# Overcomplicated Object Hierarchies and Refactoring Techniques

**AntiPattern Name:** Overcomplicated Object Hierarchies\
**Also Known As:** Class Explosion\
**Most Frequent Scale:** System Level\
**Refactored Solution Name:** Flatten Hierarchy\
**Refactored Solution Type:** Refactoring Technique

## Explanation
Overcomplicated object hierarchies occur when a system has too many classes with deep inheritance structures that make it difficult to understand or modify. This typically happens when developers overuse inheritance for modeling every aspect of a system, leading to **class explosion** and rigid designs. This makes the codebase hard to maintain and extend, as changes often require modifications across many classes in the hierarchy.

## Real-World Example of Overcomplicated Hierarchies
Older enterprise applications with complex business rules often used deep inheritance trees to represent different variations of similar entities. This led to an unmanageable number of classes and difficulties when requirements changed or new functionality had to be added.

## Examples
### 1. Deep Hierarchy for Animal Types

In some systems, developers create deep inheritance trees to represent different types of animals, leading to rigid structures.

**Example:**

Consider a class hierarchy that models different types of animals.

```java
public class Animal { }

public class Mammal extends Animal { }

public class Canine extends Mammal { }

public class Dog extends Canine { }

public class Husky extends Dog { }
```

**Problem**: Adding a new type of `Dog` or `Animal` requires creating multiple new subclasses, which adds to the complexity.

**Solution**: Use **composition** instead of inheritance to represent varying behaviors or properties.

```java
public class Animal {
    private List<Behavior> behaviors;

    public Animal(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }

    public void performBehaviors() {
        for (Behavior behavior : behaviors) {
            behavior.perform();
        }
    }
}

public interface Behavior {
    void perform();
}

public class BarkingBehavior implements Behavior {
    public void perform() {
        System.out.println("Barking...");
    }
}

public class Husky {
    private Animal animal;

    public Husky() {
        this.animal = new Animal(List.of(new BarkingBehavior()));
    }
}
```

**Benefit**: This approach makes it easier to extend functionality by adding new behaviors without modifying existing classes, resulting in a more **flexible** and **maintainable** design.

### 2. Product Variants with Deep Hierarchies

In some cases, product variants are represented with deep inheritance, leading to class explosion.

**Example:**

Consider a product hierarchy that represents different electronics.

```java
public class Product { }

public class Electronics extends Product { }

public class Mobile extends Electronics { }

public class Smartphone extends Mobile { }

public class FoldableSmartphone extends Smartphone { }
```

**Problem**: Adding a new variant like a `Tablet` requires creating multiple new subclasses, leading to a complex hierarchy.

**Solution**: Use **composition** to create product variants dynamically.

```java
public class Product {
    private List<Feature> features;

    public Product(List<Feature> features) {
        this.features = features;
    }

    public void listFeatures() {
        for (Feature feature : features) {
            feature.describe();
        }
    }
}

public interface Feature {
    void describe();
}

public class TouchScreenFeature implements Feature {
    public void describe() {
        System.out.println("Touchscreen feature");
    }
}

public class FoldableFeature implements Feature {
    public void describe() {
        System.out.println("Foldable feature");
    }
}

public class FoldableSmartphone {
    private Product product;

    public FoldableSmartphone() {
        this.product = new Product(List.of(new TouchScreenFeature(), new FoldableFeature()));
    }
}
```

**Benefit**: This approach reduces the complexity of the hierarchy by using **composition** to represent product features, making it easier to add or modify features without creating new subclasses.

### 3. Overcomplicated Shapes Hierarchy

Developers sometimes create deep inheritance hierarchies for shapes, making it challenging to extend new shapes.

**Example:**

Consider a class hierarchy for different geometric shapes.

```java
public class Shape { }

public class TwoDimensionalShape extends Shape { }

public class Circle extends TwoDimensionalShape { }

public class Rectangle extends TwoDimensionalShape { }

public class ThreeDimensionalShape extends Shape { }

public class Sphere extends ThreeDimensionalShape { }

public class Cube extends ThreeDimensionalShape { }
```

**Problem**: Adding new types of shapes requires creating multiple new subclasses, leading to deep hierarchies.

**Solution**: Use **composition** to add features to shapes.

```java
public class Shape {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    public void describe() {
        System.out.println("This is a " + type);
    }
}

public class Circle extends Shape {
    public Circle() {
        super("Circle");
    }
}

public class Sphere extends Shape {
    public Sphere() {
        super("Sphere");
    }
}
```

**Benefit**: Using composition makes it easier to extend shapes without creating deep hierarchies.

### 4. Car Types Hierarchy

In automotive systems, car types are often modeled using deep inheritance trees, making it difficult to introduce new features or variations.

**Example:**

Consider a hierarchy representing different types of cars.

```java
public class Car { }

public class Sedan extends Car { }

public class SUV extends Car { }

public class ElectricSedan extends Sedan { }

public class ElectricSUV extends SUV { }
```

**Problem**: Adding new car types requires extending multiple classes, leading to a complex hierarchy.

**Solution**: Use **composition** to create cars with specific features.

```java
public class Car {
    private String type;
    private boolean isElectric;

    public Car(String type, boolean isElectric) {
        this.type = type;
        this.isElectric = isElectric;
    }

    public void describe() {
        System.out.println("This is a " + (isElectric ? "Electric " : "") + type);
    }
}

public class ElectricSUV {
    private Car car;

    public ElectricSUV() {
        this.car = new Car("SUV", true);
    }
}
```

**Benefit**: Composition reduces the complexity of the inheritance tree and allows more flexible car configurations.

### 5. Animal Sound Hierarchy

Sound behaviors are often modeled using inheritance, leading to deep hierarchies that are difficult to manage.

**Example:**

Consider a class hierarchy for different animal sounds.

```java
public class Animal { }

public class Mammal extends Animal { }

public class Dog extends Mammal {
    public void bark() {
        System.out.println("Barking...");
    }
}

public class Cat extends Mammal {
    public void meow() {
        System.out.println("Meowing...");
    }
}
```

**Problem**: Adding new animal sounds requires adding new subclasses, leading to a complex and rigid structure.

**Solution**: Use **composition** to provide different sound behaviors to animals.

```java
public interface Sound {
    void makeSound();
}

public class BarkingSound implements Sound {
    @Override
    public void makeSound() {
        System.out.println("Barking...");
    }
}

public class MeowingSound implements Sound {
    @Override
    public void makeSound() {
        System.out.println("Meowing...");
    }
}

public class Animal {
    private Sound sound;

    public Animal(Sound sound) {
        this.sound = sound;
    }

    public void makeSound() {
        sound.makeSound();
    }
}

public class Dog {
    private Animal animal;

    public Dog() {
        this.animal = new Animal(new BarkingSound());
    }
}
```

**Benefit**: Composition allows flexibility in adding new behaviors without creating multiple subclasses.

