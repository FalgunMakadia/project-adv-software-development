package DataAccessLayer;

import java.io.IOException;

public interface IDatabaseFactory {
    ICustomerDatabase createCustomerDatabase();
    IAccountDatabase createAccountDatabase();
    IWorklistDatabase createWorkListDatabase();
    IUserDetailsDatabase createLoginDatabase() throws IOException;
}
