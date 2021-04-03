package DataAccessLayer;

import java.sql.ResultSet;

public interface IUserDetailsDatabase {
    public ResultSet validateUser(String username, int password);

    public int insertNewUser(String userName, int defaultPassword, String userRole);

    void UpdatePassword(String userName, int changedPassword);

}
