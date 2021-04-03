package DataAccessLayer;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.sql.SQLException;
import java.util.Map;

public interface IWorklistDatabase {
    int addWorkListRequest(WorklistRequest worklistRequest) throws SQLException;

    WorklistRequest getWorkListRequest(int id);

    Map<Integer, WorklistRequest> getWorkLists();

    ProfileAbstract getUserDetails(int id);

    boolean updateAssignee(int id, String assigneeUsername);

    boolean updateProcessStatus(int worklistId, Boolean isProcessed);
}
