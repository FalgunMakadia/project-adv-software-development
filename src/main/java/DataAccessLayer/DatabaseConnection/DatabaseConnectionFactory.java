package DataAccessLayer.DatabaseConnection;

public class DatabaseConnectionFactory implements IDatabaseConnectionFactory{
    @Override
    public DatabaseConnection getDatabaseConnection() {
        return DatabaseConnection.instance();
    }
}
