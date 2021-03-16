package DataAccessLayer;

import Models.User;

import java.sql.SQLException;

public interface ICustomerDatabase {
    int add(User user);
    void delete(User user);
    Models.User getUser(String accountNumber) throws SQLException;
    void updateUser(User user);
}
