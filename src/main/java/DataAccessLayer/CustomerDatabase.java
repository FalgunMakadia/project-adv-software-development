package DataAccessLayer;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.sql.*;

public class CustomerDatabase implements ICustomerDatabase {
    Connection connection = null;

    public CustomerDatabase() {
        connection = DatabaseConnection.instance();
    }

    @Override
    public boolean add(ProfileAbstract profileAbstract) {
        String createCustomer = "INSERT INTO customers (first_name, last_name, middle_name, " +
                "addressline_1, addressline_2, city, province, postal_code, email," +
                "contact_number, passport_number, ssn_number, birth_date) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String createAccount = "INSERT INTO accounts (account_no, balance, active_status) VALUES " +
                "(?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(createCustomer, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, profileAbstract.getFirstName());
            statement.setString(2, profileAbstract.getLastName());
            statement.setString(3, profileAbstract.getMiddleName());
            statement.setString(4, profileAbstract.getAddressLine1());
            statement.setString(5, profileAbstract.getAddressLine2());
            statement.setString(6, profileAbstract.getCity());
            statement.setString(7, profileAbstract.getProvince());
            statement.setString(8, profileAbstract.getPostalCode());
            statement.setString(9, profileAbstract.getEmailAddress());
            statement.setString(10, profileAbstract.getContact());
            statement.setString(11, profileAbstract.getPassport());
            statement.setString(12, profileAbstract.getSsnNo());
            statement.setString(13, profileAbstract.getDateOfBirth());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (null != resultSet && resultSet.next()) {
                long accontNumber = resultSet.getLong(1);
                if (0L != accontNumber) {
                    PreparedStatement createAccountStatement = connection.prepareStatement(createAccount);
                    int affectedRows = createAccountStatement.executeUpdate();

                    return affectedRows == 1 ? true : false;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(ProfileAbstract profileAbstract) {

    }

    @Override
    public ProfileAbstract getUser(String accountNumber) {
        String query = "SELECT * from customers WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, accountNumber);
            ProfileAbstract profileAbstract = new CustomerProfile();
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet.first());
            if (resultSet.first()) {
                profileAbstract.setFirstName(resultSet.getString("first_name"));
                profileAbstract.setLastName(resultSet.getString("last_name"));
                profileAbstract.setMiddleName(resultSet.getString("middle_name"));
                profileAbstract.setAddressLine1(resultSet.getString("addressline_1"));
                profileAbstract.setAddressLine2(resultSet.getString("addressline_2"));
                profileAbstract.setCity(resultSet.getString("city"));
                profileAbstract.setProvince(resultSet.getString("province"));
                profileAbstract.setPostalCode(resultSet.getString("postal_code"));
                profileAbstract.setEmailAddress(resultSet.getString("email"));
                profileAbstract.setContact(resultSet.getString("contact_number"));
                profileAbstract.setPassport(resultSet.getString("passport_number"));
                profileAbstract.setSsnNo(resultSet.getString("ssn_number"));
                profileAbstract.setAccountNumber(resultSet.getString("account_no"));
                profileAbstract.setDateOfBirth(resultSet.getString("birth_date"));
                return profileAbstract;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUser(String accountNumber, ProfileAbstract profileAbstract) {
        String query = "UPDATE customers SET " +
                "first_name = ?, last_name = ?, middle_name = ?, addressline_1 = ?," +
                "addressline_2 = ?, city = ?, province = ?, postal_code = ?," +
                "email = ?, contact_number = ?, passport_number = ?, ssn_number = ?," +
                "birth_date = ? WHERE account_no = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, profileAbstract.getFirstName());
            statement.setString(2, profileAbstract.getLastName());
            statement.setString(3, profileAbstract.getMiddleName());
            statement.setString(4, profileAbstract.getAddressLine1());
            statement.setString(5, profileAbstract.getAddressLine2());
            statement.setString(6, profileAbstract.getCity());
            statement.setString(7, profileAbstract.getProvince());
            statement.setString(8, profileAbstract.getPostalCode());
            statement.setString(9, profileAbstract.getEmailAddress());
            statement.setString(10, profileAbstract.getContact());
            statement.setString(11, profileAbstract.getPassport());
            statement.setString(12, profileAbstract.getSsnNo());
            statement.setString(13, profileAbstract.getDateOfBirth());
            statement.setString(14, accountNumber);

            int affectedRows = statement.executeUpdate();

            return affectedRows == 1 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
