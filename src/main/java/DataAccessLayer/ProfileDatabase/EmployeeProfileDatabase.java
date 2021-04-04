package DataAccessLayer.ProfileDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BusinessLogicLayer.User.AbstractProfile;
import DataAccessLayer.DatabaseConnection.DatabaseConnection;
import DataAccessLayer.DatabaseConnection.IDatabaseConnection;

public class EmployeeProfileDatabase implements IEmployeeProfileDatabase {
    Connection connection = null;
    IDatabaseConnection databaseConnection;

    public EmployeeProfileDatabase() {
        databaseConnection = DatabaseConnection.instance();
    }

    @Override
    public int addNewBankEmployeeProfile(AbstractProfile bankEmployeeProfile) {
        connection = databaseConnection.openConnection();
        int affectedRows = 0;
        String createEmployee = "INSERT INTO Employees (first_name,middle_name, last_name," +
                "addressline_1, addressline_2, city, province,contact_number ," +
                "email, passport_number, ssn_number, birth_date) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(createEmployee);
            statement.setString(1, bankEmployeeProfile.getFirstName());
            statement.setString(2, bankEmployeeProfile.getMiddleName());
            statement.setString(3, bankEmployeeProfile.getLastName());
            statement.setString(4, bankEmployeeProfile.getAddressLine1());
            statement.setString(5, bankEmployeeProfile.getAddressLine2());
            statement.setString(6, bankEmployeeProfile.getCity());
            statement.setString(7, bankEmployeeProfile.getProvince());
            statement.setString(8, bankEmployeeProfile.getContact());
            statement.setString(9, bankEmployeeProfile.getEmailAddress());
            statement.setString(10, bankEmployeeProfile.getPassport());
            statement.setString(11, bankEmployeeProfile.getSsnNo());
            statement.setString(12, bankEmployeeProfile.getDateOfBirth());

            affectedRows = statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return affectedRows;
    }
}
