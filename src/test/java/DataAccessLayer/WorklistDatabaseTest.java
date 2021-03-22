package DataAccessLayer;

import BusinessLogicLayer.User.Customer;
import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class WorklistDatabaseTest {
    Connection connection = DatabaseConnection.instance();

    @Mock
    PreparedStatement statement;

    User user;
    WorklistRequest worklistRequest;

    @Before
    public void setUp() throws SQLException {
        Mockito.when(connection.prepareStatement(Mockito.any(String.class))).thenReturn(statement);

        this.user = new Customer();
        this.user.setFirstName("Test");
        this.user.setLastName("User");
        this.user.setMiddleName("");
        this.user.setAddressLine1("address 1");
        this.user.setAddressLine2("address 2");
        this.user.setCity("City 1");
        this.user.setProvince(("Province"));
        this.user.setPostalCode("ABC XYZ");
        this.user.setEmailAddress("abc@gmail.com");
        this.user.setContact("123456789");
        this.user.setPassport("passportNumber");
        this.user.setSsnNo("ssn12345");

        this.worklistRequest = new WorklistRequest("change", "123456789", user);


        Mockito.when(statement.executeUpdate(Mockito.any(String.class), Statement.RETURN_GENERATED_KEYS)).thenReturn(123);
    }


    @Test
    void addWorkListRequest() throws SQLException {
        WorklistDatabase worklistDatabase = new WorklistDatabase();
        worklistDatabase.addWorkListRequest(worklistRequest);
    }

    @Test
    void getWorkListRequest() throws SQLException {
        WorklistDatabase worklistDatabase =  new WorklistDatabase();
        System.out.println("after Test" + this.worklistRequest);
        int id = worklistDatabase.addWorkListRequest(this.worklistRequest);
        System.out.println(id);
        WorklistRequest worklistFromDBMock = worklistDatabase.getWorkListRequest(id);
        assertEquals(worklistRequest, worklistFromDBMock);
    }
}