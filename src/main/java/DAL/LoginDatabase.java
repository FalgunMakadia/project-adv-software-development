package DAL;

import org.mockito.MockSettings;
import org.mockito.Mockito;

import java.sql.ResultSet;

import static org.mockito.Mockito.mock;


public class LoginDatabase implements IDatabaseSelect{
    private String username;
    private String password;
    public LoginDatabase (String username, String password){
        this.username = username;
        this.password = password;
    }
    public ResultSet operateSelect() {
        // write select query to get the details from the t_user table
        ResultSet resultSet = null;
        resultSet = mock(ResultSet.class);

        return resultSet;
    }
}
