package DataAccessLayer.OperationDatabase;

import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListActions.IWorkListRequest;

import java.util.Map;

public interface IWorklistOperationDatabase {
    int addWorkListRequest(IWorkListRequest workListRequest);

    IWorkListRequest getWorkListRequest(int id);

    Map<Integer, IWorkListRequest> getWorkList();

    AbstractProfile getWorkListUserDetail(int id);

    boolean assignWorkListRequest(int id, String assigneeUsername);

    boolean updateWorkListStatus(int worklistId, Boolean isProcessed);
}
