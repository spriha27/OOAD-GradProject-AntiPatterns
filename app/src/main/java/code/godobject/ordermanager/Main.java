package java.code.godobject.ordermanager;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        NotificationService notificationService = new NotificationService();
        BackupService backupService = new BackupService();

        orderService.createOrder();
        notificationService.sendOrderNotification();
        backupService.backupOrders();
    }
}