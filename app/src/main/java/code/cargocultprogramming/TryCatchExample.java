package java.code.cargocultprogramming;

public class TryCatchExample {
    public static void main(String[] args) {
        performOperation();
    }

    public static void performOperation() {
        // Correct solution: Removed unnecessary try-catch block
        int result = 10 + 20;
        System.out.println("Result: " + result);
    }
}