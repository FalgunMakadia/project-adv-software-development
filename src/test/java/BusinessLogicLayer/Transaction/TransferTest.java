package BusinessLogicLayer.Transaction;

import DataAccessLayer.AccountDatabase;
import DataAccessLayer.DatabaseFactory;
import DataAccessLayer.IDatabaseFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.SQLException;

public class TransferTest {

    IDatabaseFactory databaseFactory = null;
    int actual;

    @BeforeEach
    public void setup() throws SQLException {

        databaseFactory = Mockito.mock(DatabaseFactory.class);
        when(databaseFactory.createAccountDatabase()).thenReturn(new AccountDatabase());

        actual = databaseFactory.createAccountDatabase().updateBalance(10000, "9800001001");

    }

    @Test
    public void testTransfer() {

        int expected = 1;
        assertEquals(expected, actual);

    }

}