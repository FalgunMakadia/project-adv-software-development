package DataAccessLayer;

import Models.User;

import java.sql.SQLException;

public interface IAccountDatabase {
    int getUserBalance(String accountNumber) throws SQLException;
    int updateBalance(int finalBalance, String accountNumber) throws SQLException;
}
