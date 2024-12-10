package code.godobject.ordermanager;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        OrderNotificationService notificationService = new OrderNotificationService();
        BackupService backupService = new BackupService();

        orderService.createOrder();
        notificationService.sendOrderNotification();
        backupService.backupOrders();
    }
}