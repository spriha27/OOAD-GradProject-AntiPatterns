package java.code.lavaflow;

public class UserAccount {
    public void updateAccount(String accountId) {
        // The clean implementation
        updateAccountInServiceLayer(accountId);
    }

    private void updateAccountInServiceLayer(String accountId) {
        System.out.println("Updating account in service layer for: " + accountId);
    }

    public static void main(String[] args) {
        UserAccount account = new UserAccount();
        account.updateAccount("12345");
    }
}