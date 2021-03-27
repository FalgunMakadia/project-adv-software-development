package BusinessLogicLayer.CustomerAction;

import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.ICustomerDatabase;
import DataAccessLayer.IDatabaseFactory;
import DataAccessLayer.IUserDetailsDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

public class UpdatePasswordTest {
    private IUserDetailsDatabase userDetailsDatabase = null;

    private UpdatePassword updatePassword;

    @BeforeEach
    void setup() {
        IDatabaseFactory databaseFactory = new DatabaseFactory();
        updatePassword = Mockito.mock(UpdatePassword.class);
    }

    @Test
    void performAction() throws SQLException {
        Mockito.doNothing().when(updatePassword).performAction();
        updatePassword.performAction();
        Mockito.verify(updatePassword, Mockito.times(1)).performAction();
    }
}


