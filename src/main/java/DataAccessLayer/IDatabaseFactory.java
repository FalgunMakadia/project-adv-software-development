package DataAccessLayer;

import java.io.IOException;

public interface IDatabaseFactory {
    ICustomerDatabase createCustomerDatabase();
    IAccountDatabase createAccountDatabase();
    IUserDetailsDatabase createLoginDatabase() throws IOException;
}
