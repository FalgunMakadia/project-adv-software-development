package BusinessLogicLayer.TransactionAction;

public class TransactionModel {
    private String accountNumber;
    private String transactionType;
    private int amount;
    private String date;

    public TransactionModel(String accountNumber, String transactionType, int amount, String date) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
