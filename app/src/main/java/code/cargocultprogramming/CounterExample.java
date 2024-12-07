package java.code.cargocultprogramming;

public class CounterExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        System.out.println("Count: " + counter.getCount());
    }
}

class Counter {
    private int count = 0;

    // Correct solution: Removed unnecessary synchronization
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
