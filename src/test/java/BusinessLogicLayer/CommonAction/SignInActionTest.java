package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;
import DataAccessLayer.ProfileDatabase.UserProfileDatabase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;

public class SignInActionTest {

    @Test
    public void validateUserNameTest() {
        IUserProfileDatabase userProfileDatabase;
        LoggedInUserContext loggedInUserContext;
        String userName = "sam";
        int password = -401633853;
        loggedInUserContext = LoggedInUserContext.instance();
        userProfileDatabase = Mockito.mock(UserProfileDatabase.class);
        doAnswer((i) -> {
            loggedInUserContext.setUserName(userName);
            loggedInUserContext.setLoginStatus(true);
            loggedInUserContext.setAccountNumber("111");
            loggedInUserContext.setUserRole("C");
            loggedInUserContext.setActiveStatus(true);
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals("sam", loggedInUserContext.getUserName());
    }

    @Test
    public void validateCustomerRoleTest() {
        IUserProfileDatabase userProfileDatabase;
        LoggedInUserContext loggedInUserContext;
        String userName = "sam";
        int password = -401633853;
        loggedInUserContext = LoggedInUserContext.instance();
        userProfileDatabase = Mockito.mock(UserProfileDatabase.class);
        doAnswer((i) -> {
            loggedInUserContext.setUserName(userName);
            loggedInUserContext.setLoginStatus(true);
            loggedInUserContext.setAccountNumber("111");
            loggedInUserContext.setUserRole("C");
            loggedInUserContext.setActiveStatus(true);
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals("C", loggedInUserContext.getUserRole());
    }

    @Test
    public void validateEmployeeRoleTest() {
        IUserProfileDatabase userProfileDatabase;
        LoggedInUserContext loggedInUserContext;
        String userName = "sam";
        int password = -401633853;
        loggedInUserContext = LoggedInUserContext.instance();
        userProfileDatabase = Mockito.mock(UserProfileDatabase.class);
        doAnswer((i) -> {
            loggedInUserContext.setUserName(userName);
            loggedInUserContext.setLoginStatus(true);
            loggedInUserContext.setAccountNumber("111");
            loggedInUserContext.setUserRole("E");
            loggedInUserContext.setActiveStatus(true);
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals("E", loggedInUserContext.getUserRole());
    }

    @Test
    public void validateManagerRoleTest() {
        IUserProfileDatabase userProfileDatabase;
        LoggedInUserContext loggedInUserContext;
        String userName = "sam";
        int password = -401633853;
        loggedInUserContext = LoggedInUserContext.instance();
        userProfileDatabase = Mockito.mock(UserProfileDatabase.class);
        doAnswer((i) -> {
            loggedInUserContext.setUserName(userName);
            loggedInUserContext.setLoginStatus(true);
            loggedInUserContext.setAccountNumber("111");
            loggedInUserContext.setUserRole("M");
            loggedInUserContext.setActiveStatus(true);
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals("M", loggedInUserContext.getUserRole());
    }

    @Test
    public void validateUserStatusTest() {
        IUserProfileDatabase userProfileDatabase;
        LoggedInUserContext loggedInUserContext;
        String userName = "sam";
        int password = -401633853;
        loggedInUserContext = LoggedInUserContext.instance();
        userProfileDatabase = Mockito.mock(UserProfileDatabase.class);
        doAnswer((i) -> {
            loggedInUserContext.setUserName(userName);
            loggedInUserContext.setLoginStatus(true);
            loggedInUserContext.setAccountNumber("111");
            loggedInUserContext.setUserRole("C");
            loggedInUserContext.setActiveStatus(true);
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals(true, loggedInUserContext.getActiveStatus());
    }

    @Test
    public void validateAccountNumberTest() {
        IUserProfileDatabase userProfileDatabase;
        LoggedInUserContext loggedInUserContext;
        String userName = "sam";
        int password = -401633853;
        loggedInUserContext = LoggedInUserContext.instance();
        userProfileDatabase = Mockito.mock(UserProfileDatabase.class);
        doAnswer((i) -> {
            loggedInUserContext.setUserName(userName);
            loggedInUserContext.setLoginStatus(true);
            loggedInUserContext.setAccountNumber("111");
            loggedInUserContext.setUserRole("C");
            loggedInUserContext.setActiveStatus(true);
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals("111", loggedInUserContext.getAccountNumber());
    }
}