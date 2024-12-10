package code.dataclass;

public class Transaction {
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() { return amount; }
    public String getType() { return type; }

    public boolean isCredit() {
        return "credit".equalsIgnoreCase(type);
    }

    public boolean isDebit() {
        return "debit".equalsIgnoreCase(type);
    }

    public static void main(String[] args) {
        Transaction transaction = new Transaction(1000.0, "credit");
        System.out.println("Transaction Type: " + transaction.getType());
        System.out.println("Is Credit? " + transaction.isCredit());
        System.out.println("Is Debit? " + transaction.isDebit());
    }
}