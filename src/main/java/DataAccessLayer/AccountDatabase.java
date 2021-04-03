package DataAccessLayer;

import BusinessLogicLayer.TransactionAction.TransactionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.SecureRandom;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AccountDatabase implements IAccountDatabase {

    Connection connection = null;
    IDatabaseConnection databaseConnection;

    public AccountDatabase() {
        databaseConnection = DatabaseConnection.instance();
    }

    @Override
    public int getUserBalance(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT balance FROM accounts WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, accountNumber);
            ResultSet rs = statement.executeQuery();
            int balance = 0;
            if (rs.next()) {
                balance = rs.getInt("balance");
            }
            return balance;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return 0;
    }

    @Override
    public int updateBalance(int finalBalance, String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "UPDATE accounts SET balance = ? WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1, finalBalance);
            statement.setString(2, accountNumber);
            int output = statement.executeUpdate();
            return output;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return 0;
    }

    @Override
    public boolean verifyAccountNumber(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * FROM accounts WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, accountNumber);
            ResultSet rs = statement.executeQuery();
            boolean accountStatus = false;
            if (rs.next()) {
                accountStatus = rs.getBoolean("active_status");
            }
            return accountStatus;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }

    @Override
    public void saveTransaction(ArrayList<TransactionModel> saveTransactionInModel){
        connection = databaseConnection.openConnection();
        String transactionId;
        String date;

        date = getCurrentDate();

        String query = "INSERT INTO transactions VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            for (TransactionModel transaction : saveTransactionInModel) {
                transactionId = generateRandomTransactionId();
                statement.setString(1, transactionId);
                statement.setString(2, transaction.getAccountNumber());
                statement.setString(3, transaction.getTransactionType());
                statement.setInt(4, transaction.getAmount());
                statement.setString(5, date);

                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
    }

    @Override
    public ArrayList<TransactionModel> getMiniStatement(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * FROM transactions WHERE account_no = ? ORDER BY transaction_date DESC LIMIT 5";
        ArrayList<TransactionModel> transactionList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, accountNumber);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String transactionType = resultSet.getString("transaction_type");
                int amount = resultSet.getInt("transaction_amount");
                String date = resultSet.getString("transaction_date");
                transactionList.add(new TransactionModel(accountNumber, transactionType, amount, date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return transactionList;
    }

    private String generateRandomTransactionId() {
        String STR = "0123456789abcdefghijklmnopqrstuvwxyz";
        final int GENERATED_STRING_LENGTH = 10;
        int output;

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(GENERATED_STRING_LENGTH);
        for (int i = 0; i < GENERATED_STRING_LENGTH; i++) {
            sb.append(STR.charAt(random.nextInt(STR.length())));
        }
        return sb.toString();
    }

    private String getCurrentDate() {
        String date;

        DateTimeFormatter x = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        date = x.format(now);

        return date;
    }
}
