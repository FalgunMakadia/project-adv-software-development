package DataAccessLayer.DatabaseConnection;

import java.sql.Connection;

public interface IDatabaseConnection {

    Connection openConnection();

    void closeConnection();
}
