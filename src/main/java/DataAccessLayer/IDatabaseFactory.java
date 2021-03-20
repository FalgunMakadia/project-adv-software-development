package DataAccessLayer;

import java.io.IOException;

public interface IDatabaseFactory {
    ICustomerDatabase createCustomerDatabase();
    IAccountDatabase createAccountDatabase();
    ILoginDatabase createLoginDatabase() throws IOException;
    IWorklistDatabase createWorkListDatabase();
}
