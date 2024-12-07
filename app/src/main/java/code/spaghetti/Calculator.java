package java.code.spaghetti;

public class Calculator {
    public int calculateSum(int limit) {
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += i;
        }
        return sum;
    }

    public int calculateProduct(int limit) {
        int product = 1;
        for (int j = 1; j < limit; j++) {
            product *= j;
        }
        return product;
    }

    public int calculate() {
        int sum = calculateSum(10);
        int product = calculateProduct(5);
        return sum * product;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Final result: " + calculator.calculate());
    }
}