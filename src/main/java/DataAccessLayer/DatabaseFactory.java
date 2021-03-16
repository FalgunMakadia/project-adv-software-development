package DataAccessLayer;

public class DatabaseFactory implements IDatabaseFactory{
    @Override
    public ICustomerDatabase createCustomerDatabase() {
        return new CustomerDatabase();
    }
}
