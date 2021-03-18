package DataAccessLayer;

import Models.User;

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
        User user = new User();
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setMiddleName(rs.getString("middle_name"));
            user.setAddressLine1(rs.getString("addressline_1"));
            user.setAddressLine2(rs.getString("addressline_2"));
            user.setCity(rs.getString("city"));
            user.setProvince(rs.getString("province"));
            user.setPostalCode(rs.getString("postal_code"));
            user.setEmailAddress(rs.getString("email"));
            user.setContact(rs.getString("contact_number"));
            user.setPassport(rs.getString("passport_number"));
            user.setSsnNo(rs.getString("ssn_number"));

            return user;
        }
        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}
