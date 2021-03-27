package DataAccessLayer;

import BusinessLogicLayer.User.User;

import java.sql.SQLException;

public interface ICustomerDatabase {
    int add(User user);

    void delete(User user);

    User getUser(String accountNumber) throws SQLException;

    void updateUser(User user);
}
