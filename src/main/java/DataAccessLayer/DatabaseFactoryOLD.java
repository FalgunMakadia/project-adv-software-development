package DataAccessLayer;

import java.io.IOException;

public class DatabaseFactoryOLD {
    public ILoginDatabase createLoginDatabase() throws IOException {
        return new LoginDatabase();
    }
}
