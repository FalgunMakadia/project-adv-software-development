package DataAccessLayer;

import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.Connection;

public class WorklistDatabase implements IWorklistDatabase {
    Connection connection = null;

    public WorklistDatabase() {
        connection = DatabaseConnection.instance();
    }

    @Override
    public boolean addWorkListRequest(WorklistRequest worklistRequest, User user) {
        String insertWorkListQuery = "INSERT INTO worklist ()";
        return false;
    }
}
