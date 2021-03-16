package DataAccessLayer;

public interface IDatabaseFactory {
    ICustomerDatabase createCustomerDatabase();
}
