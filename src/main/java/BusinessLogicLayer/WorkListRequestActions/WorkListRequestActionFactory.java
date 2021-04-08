package BusinessLogicLayer.WorkListRequestActions;

import BusinessLogicLayer.User.AbstractProfile;

public class WorkListRequestActionFactory implements IWorkListRequestActionFactory {
    @Override
    public IWorkListRequestAction createWorkListChangeAction(IWorkListRequest workListRequest, int workListID) {
        return new WorkListChangeRequestAction(workListRequest, workListID);
    }

    @Override
    public IWorkListRequestAction createWorkListNewAccountRequest(IWorkListRequest workListRequest, int workListID) {
        return new WorkListNewAccountRequestAction(workListRequest, workListID);
    }

    @Override
    public IWorkListRequest createWorkListRequest() {
        return new WorkListRequest();
    }

    @Override
    public IWorkListRequest createWorkListRequest(String requestType, String accountNumber, AbstractProfile profile) {
        return new WorkListRequest(requestType, accountNumber, profile);
    }
}
