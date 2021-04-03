package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BusinessLogicLayer.User.BankEmployee;

public class EmployeeDatabase implements IEmployeeDatabase {
    Connection connection = null;

    public EmployeeDatabase() {
        connection = DatabaseConnection.instance();
    }


    @Override
    public void add(BankEmployee bankEmployee) {
        String createEmployee = "INSERT INTO Employees (first_name,middle_name, last_name," +
                "addressline_1, addressline_2, city, province,contact_number ," +
                "email, passport_number, ssn_number, birth_date) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        

        try {
            PreparedStatement statement = connection.prepareStatement(createEmployee);
            statement.setString(1, bankEmployee.getFirstName());
            statement.setString(2, bankEmployee.getMiddleName());
            statement.setString(3, bankEmployee.getLastName());
            statement.setString(4, bankEmployee.getAddressLine1());
            statement.setString(5, bankEmployee.getAddressLine2());
            statement.setString(6, bankEmployee.getCity());
            statement.setString(7, bankEmployee.getProvince());
            statement.setString(8, bankEmployee.getContact());
            statement.setString(9, bankEmployee.getEmailAddress());
            statement.setString(10, bankEmployee.getPassport());
            statement.setString(11, bankEmployee.getSsnNo());
            statement.setString(12, bankEmployee.getDateOfBirth());

            statement.executeUpdate();

        
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

}
}
