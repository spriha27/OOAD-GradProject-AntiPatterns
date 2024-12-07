package java.code.excessiveinheritance;

public class EmployeeExample {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Manager manager = new Manager();
        Director director = new Director();

        employee.work();
        manager.work();
        manager.manage();
        director.work();
        director.manage();
        director.strategize();
    }
}

interface Workable {
    void work();
}

interface Manageable {
    void manage();
}

interface Strategizable {
    void strategize();
}

class Employee implements Workable {
    @Override
    public void work() {
        System.out.println("Working...");
    }
}

class Manager implements Workable, Manageable {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void manage() {
        System.out.println("Managing...");
    }
}

class Director implements Workable, Manageable, Strategizable {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void manage() {
        System.out.println("Managing...");
    }

    @Override
    public void strategize() {
        System.out.println("Strategizing...");
    }
}