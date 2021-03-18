package DataAccessLayer;

import java.io.IOException;

public interface IDatabaseFactory {
    ICustomerDatabase createCustomerDatabase();
    ILoginDatabase createLoginDatabase() throws IOException;
}
