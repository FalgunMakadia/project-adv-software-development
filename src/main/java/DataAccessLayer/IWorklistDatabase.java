package DataAccessLayer;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IWorklistDatabase {
    int addWorkListRequest(WorklistRequest worklistRequest) throws SQLException;

    WorklistRequest getWorkListRequest(int id);

    ArrayList<WorklistRequest> getWorkLists();
}
