package DataAccessLayer;

import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDatabase implements ICustomerDatabase {
    Connection connection = null;

    public CustomerDatabase(){
         connection = DatabaseConnection.instance();
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getUser(String accountNumber) throws SQLException {
        String query = "SELECT * from customers WHERE account_no = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, accountNumber);
        User user = new Customer();
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet.first());
        if (resultSet.first()) {
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setMiddleName(resultSet.getString("middle_name"));
            user.setAddressLine1(resultSet.getString("addressline_1"));
            user.setAddressLine2(resultSet.getString("addressline_2"));
            user.setCity(resultSet.getString("city"));
            user.setProvince(resultSet.getString("province"));
            user.setPostalCode(resultSet.getString("postal_code"));
            user.setEmailAddress(resultSet.getString("email"));
            user.setContact(resultSet.getString("contact_number"));
            user.setPassport(resultSet.getString("passport_number"));
            user.setSsnNo(resultSet.getString("ssn_number"));
            user.setAccountNumber(resultSet.getString("account_no"));
            user.setDateOfBirth(resultSet.getString("birth_date"));
            return user;
        }
        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}
