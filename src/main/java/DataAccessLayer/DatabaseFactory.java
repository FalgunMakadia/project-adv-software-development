package DataAccessLayer;

import java.io.IOException;

public class DatabaseFactory implements IDatabaseFactory{
    @Override
    public ICustomerDatabase createCustomerDatabase() {
        return new CustomerDatabase();
    }

    @Override
    public ILoginDatabase createLoginDatabase() throws IOException {
        return new LoginDatabase();
    }
}
