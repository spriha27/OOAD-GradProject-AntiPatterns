package java.code.spaghetti;

public class UserManagement {
    public static void main(String[] args) {
        UserService userService = new UserService();
        NotificationService notificationService = new NotificationService();
        BackupService backupService = new BackupService();

        userService.createUser();
        notificationService.sendNotification("Welcome!");
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

class NotificationService {
    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}

class BackupService {
    public void backupDatabase() {
        System.out.println("Backing up database...");
    }
}