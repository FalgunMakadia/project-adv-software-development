package DataAccessLayer;

import java.sql.Connection;

public interface IDatabaseConnection {
    static DatabaseConnection instance() {
        return null;
    }

    Connection openConnection();

    void closeConnection();
}
