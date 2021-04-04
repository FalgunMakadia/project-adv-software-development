package BusinessLogicLayer.Transaction;

import DataAccessLayer.OperationDatabase.AccountOperationDatabase;
import DataAccessLayer.DatabaseFactory.DatabaseFactory;
import DataAccessLayer.DatabaseFactory.IDatabaseFactory;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

public class CheckBalanceTest {

    IDatabaseFactory databaseFactory = null;
    IAccountOperationDatabase accountOperationDatabase;
    int actual;

    @BeforeEach
    public void setup() throws SQLException {

//        databaseFactory = Mockito.mock(DatabaseFactory.class);
//        when(databaseFactory.createAccountDatabase()).thenReturn(new AccountOperationDatabase());
//
//        actual = databaseFactory.createAccountDatabase().getBalance("9800001001");

    }

    @Test
    public void testCheckBalance() {
//
//        int expected = 10000;
//        assertEquals(expected, actual);

    }

}