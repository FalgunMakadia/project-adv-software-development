package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.AbstractProfile;

public class WorkListActionFactory implements IWorkListActionFactory{
    @Override
    public IWorkListAction createWorkListChangeAction(IWorkListRequest workListRequest, int workListID) {
        return new WorkListChangeAction(workListRequest, workListID);
    }

    @Override
    public IWorkListAction createWorkListNewAccountRequest(IWorkListRequest workListRequest, int workListID) {
        return new WorkListNewAccountRequest(workListRequest, workListID);
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
