package DataAccessLayer;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.sql.*;

public class CustomerDatabase implements ICustomerDatabase {
    private static final String FIRST_NAME_COLUMN_NAME = "first_name";
    private static final String LAST_NAME_COLUMN_NAME = "last_name";
    private static final String MIDDLE_NAME_COLUMN_NAME = "middle_name";
    private static final String ADDRESSLINE_1_COLUMN_NAME = "addressline_1";
    private static final String ADDRESSLINE_2_COLUMN_NAME = "addressline_2";
    private static final String CITY_COLUMN_NAME = "city";
    private static final String PROVINCE_COLUMN_NAME = "province";
    private static final String POSTAL_CODE_COLUMN_NAME = "postal_code";
    private static final String EMAIL_COLUMN_NAME = "email";
    private static final String CONTACT_NUMBER_COLUMN_NAME = "contact_number";
    private static final String PASSPORT_NUMBER_COLUMN_NAME = "passport_number";
    private static final String SSN_NUMBER_COLUMN_NAME = "ssn_number";
    private static final String ACCOUNT_NUMBER_COLUMN_NAME = "account_no";
    private static final String BIRTH_DATE_COLUMN_NAME = "birth_date";

    Connection connection = null;
    IDatabaseConnection databaseConnection;

    public CustomerDatabase() {
        databaseConnection = DatabaseConnection.instance();
    }

    @Override
    public boolean addNewCustomerProfile(ProfileAbstract profile) {
        connection = databaseConnection.openConnection();
        String createCustomer = "INSERT INTO customers (first_name, last_name, middle_name, " +
                "addressline_1, addressline_2, city, province, postal_code, email," +
                "contact_number, passport_number, ssn_number, birth_date) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String createAccount = "INSERT INTO accounts (account_no, balance, active_status) VALUES " +
                "(?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(createCustomer, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, profile.getFirstName());
            statement.setString(2, profile.getLastName());
            statement.setString(3, profile.getMiddleName());
            statement.setString(4, profile.getAddressLine1());
            statement.setString(5, profile.getAddressLine2());
            statement.setString(6, profile.getCity());
            statement.setString(7, profile.getProvince());
            statement.setString(8, profile.getPostalCode());
            statement.setString(9, profile.getEmailAddress());
            statement.setString(10, profile.getContact());
            statement.setString(11, profile.getPassport());
            statement.setString(12, profile.getSsnNo());
            statement.setString(13, profile.getDateOfBirth());

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
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }

    @Override
    public ProfileAbstract getCustomerProfile(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * from customers WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, accountNumber);
            ProfileAbstract profile = new CustomerProfile();
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.first()) {
                profile.setFirstName(resultSet.getString(FIRST_NAME_COLUMN_NAME));
                profile.setLastName(resultSet.getString(LAST_NAME_COLUMN_NAME));
                profile.setMiddleName(resultSet.getString(MIDDLE_NAME_COLUMN_NAME));
                profile.setAddressLine1(resultSet.getString(ADDRESSLINE_1_COLUMN_NAME));
                profile.setAddressLine2(resultSet.getString(ADDRESSLINE_2_COLUMN_NAME));
                profile.setCity(resultSet.getString(CITY_COLUMN_NAME));
                profile.setProvince(resultSet.getString(PROVINCE_COLUMN_NAME));
                profile.setPostalCode(resultSet.getString(POSTAL_CODE_COLUMN_NAME));
                profile.setEmailAddress(resultSet.getString(EMAIL_COLUMN_NAME));
                profile.setContact(resultSet.getString(CONTACT_NUMBER_COLUMN_NAME));
                profile.setPassport(resultSet.getString(PASSPORT_NUMBER_COLUMN_NAME));
                profile.setSsnNo(resultSet.getString(SSN_NUMBER_COLUMN_NAME));
                profile.setAccountNumber(resultSet.getString(ACCOUNT_NUMBER_COLUMN_NAME));
                profile.setDateOfBirth(resultSet.getString(BIRTH_DATE_COLUMN_NAME));
                return profile;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return null;
    }

    @Override
    public boolean updateCustomerProfile(String accountNumber, ProfileAbstract profile) {
        connection = databaseConnection.openConnection();
        String query = "UPDATE customers SET " +
                "first_name = ?, last_name = ?, middle_name = ?, addressline_1 = ?," +
                "addressline_2 = ?, city = ?, province = ?, postal_code = ?," +
                "email = ?, contact_number = ?, passport_number = ?, ssn_number = ?," +
                "birth_date = ? WHERE account_no = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, profile.getFirstName());
            statement.setString(2, profile.getLastName());
            statement.setString(3, profile.getMiddleName());
            statement.setString(4, profile.getAddressLine1());
            statement.setString(5, profile.getAddressLine2());
            statement.setString(6, profile.getCity());
            statement.setString(7, profile.getProvince());
            statement.setString(8, profile.getPostalCode());
            statement.setString(9, profile.getEmailAddress());
            statement.setString(10, profile.getContact());
            statement.setString(11, profile.getPassport());
            statement.setString(12, profile.getSsnNo());
            statement.setString(13, profile.getDateOfBirth());
            statement.setString(14, accountNumber);

            int affectedRows = statement.executeUpdate();

            return affectedRows == 1 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }
}
