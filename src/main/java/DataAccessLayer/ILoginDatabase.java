package DataAccessLayer;

import java.sql.ResultSet;

public interface ILoginDatabase {
    public ResultSet validateUser (String username, int password);
}
