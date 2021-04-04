package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.AbstractProfile;

public interface IWorkListRequest {
    AbstractProfile getUser();

    void setUser(AbstractProfile profile);

    String getRequestType();

    void setRequestType(String requestType);

    String getPriority();

    void setPriority(String priority);

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    String getHandledBy();

    void setHandledBy(String handledBy);
}
