package code.excessiveinheritance;

public class Vehicle {
    private Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public void startEngine() {
        engine.start();
    }
}

class Engine {
    public void start() {
        System.out.println("Engine starting...");
    }
}