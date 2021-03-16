package BusinessLogicLayer.User;

public interface ILoggedInUserContext {
    static LoggedInUserContext Instance() {
        return null;
    }

    String getUserName();
    void setUserName(String userName);
    String getUserRole();
    void setUserRole(String userRole);
    String getAccountNumber();
    void setAccountNumber(String accountNumber);
    Boolean getActiveStatus();
    void setActiveStatus(Boolean activeStatus);
    void setLoginStatus(Boolean loginStatus);
    Boolean getLoginStatus();


}
