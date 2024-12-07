package java.code.overcomplicatedobject;

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

    public static void main(String[] args) {
        Car electricSUV = new Car("SUV", true);
        electricSUV.describe();

        Car sedan = new Car("Sedan", false);
        sedan.describe();
    }
}