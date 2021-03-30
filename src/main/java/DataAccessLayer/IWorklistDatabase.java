package DataAccessLayer;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;
import java.util.Map;

public interface IWorklistDatabase {
    int addWorkListRequest(WorklistRequest worklistRequest) throws SQLException;

    WorklistRequest getWorkListRequest(int id);

    Map<Integer, WorklistRequest> getWorkLists();
}
