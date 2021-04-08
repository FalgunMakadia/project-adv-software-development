package BusinessLogicLayer.WorkListRequestActions;

import BusinessLogicLayer.User.AbstractProfile;

public interface IWorkListRequestActionFactory {

    IWorkListRequestAction createWorkListChangeAction(IWorkListRequest workListRequest, int workListID);

    IWorkListRequestAction createWorkListNewAccountRequest(IWorkListRequest workListRequest, int workListID);

    IWorkListRequest createWorkListRequest();

    IWorkListRequest createWorkListRequest(String requestType, String accountNumber, AbstractProfile profile);
}
