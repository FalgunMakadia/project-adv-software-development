package DataAccessLayer;

import java.io.IOException;

public class DatabaseFactory implements IDatabaseFactory{
    @Override
    public ICustomerDatabase createCustomerDatabase() {
        return new CustomerDatabase();
    }

    @Override
    public IAccountDatabase createAccountDatabase() {
        return new AccountDatabase();
    }

    @Override
    public IUserDetailsDatabase createLoginDatabase() throws IOException {
        return new UserDetailsDatabase();
    }
}
