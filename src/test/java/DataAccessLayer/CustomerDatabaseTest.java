package DataAccessLayer;

import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDatabaseTest {
    @Mock
    Connection connection;

    @Mock
    PreparedStatement statement;

    @Mock
    ResultSet resultSet;

    User user;

    @Before
    public void setup() throws SQLException {
        Mockito.when(this.connection.prepareStatement(Mockito.any(String.class))).thenReturn(statement);

        user = new Customer();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setMiddleName("");
        user.setAddressLine1("address 1");
        user.setAddressLine2("address 2");
        user.setCity("City 1");
        user.setProvince(("Province"));
        user.setPostalCode("ABC XYZ");
        user.setEmailAddress("abc@gmail.com");
        user.setContact("123456789");
        user.setPassport("passportNumber");
        user.setSsnNo("ssn12345");

        Mockito.when(resultSet.getString("first_name")).thenReturn(user.getFirstName());
        Mockito.when(resultSet.getString("last_name")).thenReturn(user.getLastName());
        Mockito.when(resultSet.getString("middle_name")).thenReturn(user.getMiddleName());
        Mockito.when(resultSet.getString("addressline_1")).thenReturn(user.getAddressLine1());
        Mockito.when(resultSet.getString("addressline_2")).thenReturn(user.getAddressLine2());
        Mockito.when(resultSet.getString("city")).thenReturn(user.getCity());
        Mockito.when(resultSet.getString("province")).thenReturn(user.getProvince());
        Mockito.when(resultSet.getString("postal_code")).thenReturn(user.getPostalCode());
        Mockito.when(resultSet.getString("email")).thenReturn(user.getEmailAddress());
        Mockito.when(resultSet.getString("contact_number")).thenReturn(user.getContact());
        Mockito.when(resultSet.getString("passport_number")).thenReturn(user.getPassport());
        Mockito.when(resultSet.getString("ssn_number")).thenReturn(user.getSsnNo());
        Mockito.when(statement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.first()).thenReturn(true);

    }

    @Test
    void getUser() throws SQLException {
        CustomerDatabase database = new CustomerDatabase();
        database.add(user);
        System.out.println(user);
        User userFromDBMock = database.getUser("12345678");
        System.out.println(userFromDBMock);
        assertEquals(user, userFromDBMock);
    }

    @Test
    void add() {
        new CustomerDatabase().add(user);
    }
}