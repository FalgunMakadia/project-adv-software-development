package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.User.AbstractProfile;

public class WorkListRequest implements IWorkListRequest {
    private AbstractProfile profile;
    private String requestType;
    private static String priority = "low";
    private String accountNumber;
    private String handledBy = null;

    public WorkListRequest() {
    }

    public WorkListRequest(String requestType, String accountNumber, AbstractProfile profile) {
        this.requestType = requestType;
        this.accountNumber = accountNumber;
        this.profile = profile;
    }

    public AbstractProfile getUser() {
        return profile;
    }

    public void setUser(AbstractProfile profile) {
        this.profile = profile;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(String handledBy) {
        this.handledBy = handledBy;
    }
}
