package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.ProfileAbstract;

public interface IWorkListRequest {
    ProfileAbstract getUser();

    void setUser(ProfileAbstract profileAbstract);

    String getRequestType();

    void setRequestType(String requestType);

    String getPriority();

    void setPriority(String priority);

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    String getHandledBy();

    void setHandledBy(String handledBy);
}
