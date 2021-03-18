package DataAccessLayer;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
