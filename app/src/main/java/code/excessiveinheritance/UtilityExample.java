package code.excessiveinheritance;

public class UtilityExample {
    public static void main(String[] args) {
        Application app = new Application();
        app.performTask();
    }
}

class Utility {
    public static void log(String message) {
        System.out.println(message);
    }
}

class Application {
    public void performTask() {
        Utility.log("Task performed");
    }
}