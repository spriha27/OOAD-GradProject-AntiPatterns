package code.spaghetti;

public class UserManagement {
    private SpaghettiNotificationService notificationService = new SpaghettiNotificationService();

    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        UserService userService = new UserService();
        BackupService backupService = new BackupService();

        userService.createUser();
        userManagement.notificationService.sendNotification("Welcome!");
        backupService.backupDatabase();
    }
}

class UserService {
    public void createUser() {
        System.out.println("Creating user...");
    }

    public void deleteUser() {
        System.out.println("Deleting user...");
    }
}

class BackupService {
    public void backupDatabase() {
        System.out.println("Backing up database...");
    }
}