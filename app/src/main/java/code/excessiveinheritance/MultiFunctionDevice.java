package java.code.excessiveinheritance;

public class MultiFunctionDevice {
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionDevice(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void print() {
        printer.print();
    }

    public void scan() {
        scanner.scan();
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner scanner = new Scanner();
        MultiFunctionDevice device = new MultiFunctionDevice(printer, scanner);

        device.print();
        device.scan();
    }
}

class Printer {
    public void print() {
        System.out.println("Printing...");
    }
}

class Scanner {
    public void scan() {
        System.out.println("Scanning...");
    }
}