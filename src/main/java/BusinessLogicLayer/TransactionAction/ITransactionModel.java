package BusinessLogicLayer.TransactionAction;

public interface ITransactionModel {

    public String getAccountNumber();

    public void setAccountNumber(String accountNumber);

    public String getTransactionType();

    public int getAmount();

    public String getDate();

    public String generateRandomTransactionId();

    public String getCurrentDate();

}
