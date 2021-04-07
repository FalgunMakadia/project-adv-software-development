package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignOutActionTest {
    ILoggedInUserContext loggedInUserContext;

    @BeforeEach
    void performSignOut() {
        loggedInUserContext = LoggedInUserContext.instance();
        IAction signOutAction = new SignOutAction();
        signOutAction.performAction();
    }

    @Test
    void getActionTitle() {
        IAction signOutAction = new SignOutAction();
        assertEquals("Sign Out", signOutAction.getActionTitle());
    }

    @Test
    void currentPageInContextTest() {
        assertEquals("", loggedInUserContext.getCurrentPage());
    }

    @Test
    void userNameTest() {
        assertEquals(null, loggedInUserContext.getUserName());
    }

    @Test
    void userRoleTest() {
        assertEquals(null, loggedInUserContext.getUserRole());
    }

    @Test
    void accountNumberTest() {
        assertEquals(null, loggedInUserContext.getAccountNumber());
    }

    @Test
    void activeStatusTest() {
        assertEquals(false, loggedInUserContext.getActiveStatus());
    }

    @Test
    void loginStatusTest() {
        assertEquals(false, loggedInUserContext.getLoginStatus());
    }
}