package DataAccessLayer;

import BusinessLogicLayer.User.User;

import java.sql.SQLException;

public interface ICustomerDatabase {
    boolean add(User user);

    void delete(User user);

    User getUser(String accountNumber) throws SQLException;

    boolean updateUser(String accountNumber, User user);
}
