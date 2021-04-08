package DataAccessLayer.ProfileDatabase;

import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.AbstractProfile;
import DataAccessLayer.DatabaseConnection.DatabaseConnection;
import DataAccessLayer.DatabaseConnection.IDatabaseConnection;

import java.sql.*;

public class CustomerProfileDatabase implements ICustomerProfileDatabase {
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

    public CustomerProfileDatabase() {
        databaseConnection = DatabaseConnection.instance();
    }

    @Override
    public boolean addNewCustomerProfile(AbstractProfile profile) {

        int affectedRows = 0;
        connection = databaseConnection.openConnection();
        String createCustomer = "INSERT INTO customers (first_name, last_name, middle_name, " +
                "addressline_1, addressline_2, city, province, postal_code, email," +
                "contact_number, passport_number, ssn_number, birth_date) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String createAccount = "INSERT INTO accounts (account_no, active_status) VALUES " +
                "(?, ?)";
        String activateUserCredentials = "UPDATE INTO login SET accountNumber = ?, ActiveStatus = ? WHERE userName = ?";

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
                long accountNumber = resultSet.getLong(1);

                if (0L < accountNumber) {
                    PreparedStatement createAccountStatement = connection.prepareStatement(createAccount);
                    createAccountStatement.setLong(1, accountNumber);
                    createAccountStatement.setBoolean(2, true);
                    createAccountStatement.executeUpdate();
                    PreparedStatement activeUserCredentialsStatement = connection.prepareStatement(activateUserCredentials);
                    activeUserCredentialsStatement.setLong(1, accountNumber);
                    activeUserCredentialsStatement.setBoolean(2, true);
                    activeUserCredentialsStatement.setString(3, profile.getUserName());

                    affectedRows = activeUserCredentialsStatement.executeUpdate();

                    if (affectedRows == 1) {
                        return true;
                    }
                    return false;
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
    public AbstractProfile getCustomerProfile(String accountNumber) {
        connection = databaseConnection.openConnection();
        String query = "SELECT * from customers WHERE account_no = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, accountNumber);
            AbstractProfile profile = new CustomerProfile();
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
    public boolean updateCustomerProfile(String accountNumber, AbstractProfile profile) {
        int affectedRows = 0;
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
            affectedRows = statement.executeUpdate();
            return affectedRows == 1 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }
}