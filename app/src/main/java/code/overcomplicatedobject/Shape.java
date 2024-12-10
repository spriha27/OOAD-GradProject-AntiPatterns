package code.overcomplicatedobject;

public class Shape {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    public void describe() {
        System.out.println("This is a " + type);
    }

    public static void main(String[] args) {
        Shape circle = new Shape("Circle");
        Shape sphere = new Shape("Sphere");

        circle.describe();
        sphere.describe();
    }
}