package DataAccessLayer;

import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;

public interface IWorklistDatabase {
    int addWorkListRequest(WorklistRequest worklistRequest) throws SQLException;

    WorklistRequest getWorkListRequest(int id);
}
