package java.code.dataclass;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void giveRaise(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Raise percentage must be positive");
        }
        this.salary += salary * percentage / 100;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Jane Smith", 50000);
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Current Salary: $" + employee.getSalary());

        employee.giveRaise(10.0);
        System.out.println("New Salary: $" + employee.getSalary());
    }
}