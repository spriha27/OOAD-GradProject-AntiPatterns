package java.code.lavaflow;

public class NewProcessor {
    public void processNewData() {
        System.out.println("Processing new data...");
    }

    public static void main(String[] args) {
        NewProcessor processor = new NewProcessor();
        processor.processNewData();
    }
}