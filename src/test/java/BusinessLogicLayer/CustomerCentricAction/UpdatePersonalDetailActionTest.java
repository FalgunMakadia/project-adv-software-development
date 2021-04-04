package BusinessLogicLayer.CustomerCentricAction;

import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.ProfileDatabase.ICustomerProfileDatabase;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

class UpdatePersonalDetailActionTest {
    private ICustomerProfileDatabase customerDatabase = null;

    private UpdatePersonalDetailAction updatePersonalDetailAction;

    @BeforeEach
    void setup() {
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        updatePersonalDetailAction = Mockito.mock(UpdatePersonalDetailAction.class);
    }

    @Test
    void performAction() throws SQLException {
        Mockito.doNothing().when(updatePersonalDetailAction).performAction();
        updatePersonalDetailAction.performAction();
        Mockito.verify(updatePersonalDetailAction, Mockito.times(1)).performAction();
    }
}