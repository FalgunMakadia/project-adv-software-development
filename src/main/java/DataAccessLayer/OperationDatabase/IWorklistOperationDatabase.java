package DataAccessLayer.OperationDatabase;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorkListActions.IWorkListRequest;

import java.util.Map;

public interface IWorklistOperationDatabase {
    int addWorkListRequest(IWorkListRequest workListRequest);

    IWorkListRequest getWorkListRequest(int id);

    Map<Integer, IWorkListRequest> getWorkList();

    ProfileAbstract getWorkListUserDetail(int id);

    boolean assignWorkListRequest(int id, String assigneeUsername);

    boolean updateWorkListStatus(int worklistId, Boolean isProcessed);
}
