package DataAccessLayer;

import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;
import java.util.Map;

public interface IWorklistDatabase {
    int addWorkListRequest(WorklistRequest worklistRequest) throws SQLException;

    WorklistRequest getWorkListRequest(int id);

    Map<Integer, WorklistRequest> getWorkLists();

    User getUserDetails(int id);

    boolean updateAssignee(int id, String assigneeUsername);
}
