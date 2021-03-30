package BusinessLogicLayer.WorklistRequest;

import BusinessLogicLayer.User.User;

public class WorklistRequest {
    private User user;
    private String requestType;
    private String priority = "low";
    private String accountNumber;
    private String handledBy = null;

    public WorklistRequest() {
    }

    public WorklistRequest(String requestType, String accountNumber, User user) {
        this.requestType = requestType;
        this.accountNumber = accountNumber;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
