package BusinessLogicLayer.User;

public class LoggedInUserContext implements ILoggedInUserContext {
    private static LoggedInUserContext uniqueInstance = null;
    private String userName;
    private String userRole;
    private String accountNumber;
    private Boolean activeStatus = Boolean.FALSE;
    private Boolean loginStatus = Boolean.FALSE;
    private String currentPage;
    private String parentPage;

    private LoggedInUserContext() {
    }

    public static LoggedInUserContext instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new LoggedInUserContext();
        }
        return uniqueInstance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setParentPage(String parentPage) {
        this.parentPage = parentPage;
    }

    public boolean checkCurrentPageStatus(String menuLabel) {
        return currentPage.equals(menuLabel);
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }
}
