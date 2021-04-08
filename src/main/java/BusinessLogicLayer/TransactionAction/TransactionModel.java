package BusinessLogicLayer.TransactionAction;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionModel implements ITransactionModel{
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

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

    public String generateRandomTransactionId() {
        final String STR = "0123456789abcdefghijklmnopqrstuvwxyz";
        final int GENERATED_STRING_LENGTH = 10;

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(GENERATED_STRING_LENGTH);
        for (int i = 0; i < GENERATED_STRING_LENGTH; i++) {
            sb.append(STR.charAt(random.nextInt(STR.length())));
        }
        return sb.toString();
    }

    public String getCurrentDate() {
        String date;

        DateTimeFormatter x = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime now = LocalDateTime.now();
        date = x.format(now);

        return date;
    }

}
