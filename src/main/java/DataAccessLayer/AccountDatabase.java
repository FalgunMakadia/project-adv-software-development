package DataAccessLayer;

import BusinessLogicLayer.TransactionModal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.SecureRandom;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AccountDatabase implements IAccountDatabase{

    Connection connection = null;

    public AccountDatabase() {
        connection = DatabaseConnection.instance();
    }

    @Override
    public int getUserBalance(String accountNumber) throws SQLException {
        String query = "SELECT balance FROM accounts WHERE account_no = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, accountNumber);
        ResultSet rs = statement.executeQuery();
        int balance = 0;
        if(rs.next()){
            balance = rs.getInt("balance");
        }
        return balance;
    }

    @Override
    public int updateBalance(int finalBalance, String accountNumber) throws SQLException {

        String query = "UPDATE accounts SET balance = ? WHERE account_no = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, finalBalance);
        statement.setString(2, accountNumber);
        int output = statement.executeUpdate();
        return output;
    }

    @Override
    public boolean verifyAccountNumber(String accountNumber) throws SQLException {
        String query = "SELECT * FROM accounts WHERE account_no = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, accountNumber);
        ResultSet rs = statement.executeQuery();
        boolean accountStatus= false;
        if(rs.next()){
            accountStatus = rs.getBoolean("active_status");
        }
        return accountStatus;
    }

    @Override
    public int saveTransaction(String accountNumber, String transactionType, int amount) throws SQLException {
        String STR = "0123456789abcdefghijklmnopqrstuvwxyz";
        String transactionId;
        String date;
        int output;

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++)
            sb.append(STR.charAt(random.nextInt(STR.length())));
        transactionId = sb.toString();

        DateTimeFormatter x = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        date = x.format(now);

        String query = "INSERT INTO transactions VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, transactionId);
        statement.setString(2, accountNumber);
        statement.setString(3, transactionType);
        statement.setInt(4, amount);
        statement.setString(5, date);

        output = statement.executeUpdate();
        return  output;
    }

    @Override
    public ArrayList<TransactionModal> getMiniStatement(String accountNumber) throws SQLException {
        String query = "SELECT * FROM transactions WHERE account_no = ? ORDER BY transaction_date DESC LIMIT 5";
        ArrayList<TransactionModal> transactionList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, accountNumber);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String transactionType = resultSet.getString("transaction_type");
            int amount = resultSet.getInt("transaction_amount");
            String date = resultSet.getString("transaction_date");
            transactionList.add(new TransactionModal(accountNumber, transactionType, amount, date));
        }
        return transactionList;
    }
}
