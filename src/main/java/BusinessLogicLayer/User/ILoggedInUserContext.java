package BusinessLogicLayer.User;

public interface ILoggedInUserContext {
    static LoggedInUserContext Instance() {
        return null;
    }
    Boolean getLoginStatus();
    String getUserName();
    void setUserName(String userName);
    String getUserRole();
    void setUserRole(String userRole);
    String getAccountNumber();
    void setAccountNumber(String accountNumber);
    Boolean getActiveStatus();
    void setActiveStatus(Boolean activeStatus);
    void setLoginStatus(Boolean loginStatus);
    void setCurrentPage(String currentPage);
    void clearCurrentPage();
    String getCurrentPage();
    void setParentPage(String parentPage);

    boolean checkCurrentPageStatus(String menuLabel);
}
