package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.ProfileAbstract;

public interface IWorkListActionFactory {

    IWorkListAction createWorkListChangeAction(IWorkListRequest workListRequest, int workListID);

    IWorkListAction createWorkListNewAccountRequest(IWorkListRequest workListRequest, int workListID);

    IWorkListRequest createWorkListRequest();

    IWorkListRequest createWorkListRequest(String requestType, String accountNumber, ProfileAbstract profileAbstract);
}
