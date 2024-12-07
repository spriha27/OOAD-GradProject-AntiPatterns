package java.code.excessiveinheritance;

public class BirdExample {
    public static void main(String[] args) {
        Bird sparrow = new Bird();
        Penguin penguin = new Penguin();

        sparrow.fly();
        penguin.eat();
    }
}

class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
}

interface Flyable {
    void fly();
}

class Bird extends Animal implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Animal {
    // Penguins do not implement Flyable
}