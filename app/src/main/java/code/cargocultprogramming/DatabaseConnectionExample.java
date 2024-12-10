package code.cargocultprogramming;

@SuppressWarnings("unused")
public class DatabaseConnectionExample {
    public static void main(String[] args) {
        DatabaseConnection dbConnection1 = new DatabaseConnection();
        DatabaseConnection dbConnection2 = new DatabaseConnection();
        System.out.println("Two database connections created successfully.");
    }
}

class DatabaseConnection {
    public DatabaseConnection() {
        // Initialization logic
        System.out.println("DatabaseConnection initialized.");
    }
}