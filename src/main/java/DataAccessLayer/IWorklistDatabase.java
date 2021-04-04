package DataAccessLayer;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

import java.util.Map;

public interface IWorklistDatabase {
    int addWorkListRequest(WorklistRequest worklistRequest);

    WorklistRequest getWorkListRequest(int id);

    Map<Integer, WorklistRequest> getWorkList();

    ProfileAbstract getWorkListUserDetail(int id);

    boolean assignWorkListRequest(int id, String assigneeUsername);

    boolean updateWorkListStatus(int worklistId, Boolean isProcessed);
}
