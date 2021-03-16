package BusinessLogicLayer;

import DAL.ILoginDatabase;
import DAL.LoginDatabase;

import java.io.IOException;

public class DatabaseFactory {
    public ILoginDatabase createLoginDatabase() throws IOException {
        return new LoginDatabase();
    }
}
