package DataAccessLayer;

import java.sql.ResultSet;

public interface IUserDetailsDatabase {
    void validateUser(String username, int password);

    int insertNewUser(String userName, int defaultPassword, String userRole);

    void UpdatePassword(String userName, int changedPassword);

}
