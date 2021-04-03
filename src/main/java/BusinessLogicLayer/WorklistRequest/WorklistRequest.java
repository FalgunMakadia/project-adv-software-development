package BusinessLogicLayer.WorklistRequest;

import BusinessLogicLayer.User.ProfileAbstract;

public class WorklistRequest {
    private ProfileAbstract profileAbstract;
    private String requestType;
    private String priority = "low";
    private String accountNumber;
    private String handledBy = null;

    public WorklistRequest() {
    }

    public WorklistRequest(String requestType, String accountNumber, ProfileAbstract profileAbstract) {
        this.requestType = requestType;
        this.accountNumber = accountNumber;
        this.profileAbstract = profileAbstract;
    }

    public ProfileAbstract getUser() {
        return profileAbstract;
    }

    public void setUser(ProfileAbstract profileAbstract) {
        this.profileAbstract = profileAbstract;
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
