package BusinessLogicLayer.CustomerAction;

import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.ICustomerDatabase;
import DataAccessLayer.IDatabaseFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UpdatePersonalDetailsTest {
    private ICustomerDatabase customerDatabase = null;

    private UpdatePersonalDetails updatePersonalDetails;

    @BeforeEach
    void setup() {
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        updatePersonalDetails = Mockito.mock(UpdatePersonalDetails.class);
    }

    @Test
    void performAction() throws SQLException {
        Mockito.doNothing().when(updatePersonalDetails).performAction();
        updatePersonalDetails.performAction();
        Mockito.verify(updatePersonalDetails, Mockito.times(1)).performAction();
    }
}