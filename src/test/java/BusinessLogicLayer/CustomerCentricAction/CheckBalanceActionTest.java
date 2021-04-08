package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.CommonAction.SignInAction;
import BusinessLogicLayer.CustomerCentricAction.CheckBalanceAction;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.OperationDatabase.AccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;
import DataAccessLayer.ProfileDatabase.UserProfileDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doAnswer;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBalanceActionTest {

    private CheckBalanceAction checkBalanceAction;

    @BeforeEach
    public void setup() {
        checkBalanceAction = Mockito.mock(CheckBalanceAction.class);
    }

    @Test
    void getActionTitleTest() {
        IAbstractAction checkBalanceAction = new CheckBalanceAction();
        assertEquals("Check Balance", checkBalanceAction.getActionTitle());
    }

    @Test
    void performAction() {
        Mockito.doNothing().when(checkBalanceAction).performAction();
        checkBalanceAction.performAction();
        Mockito.verify(checkBalanceAction, Mockito.times(1)).performAction();
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
            loggedInUserContext.setAccountNumber("9800001003");
            loggedInUserContext.setUserRole("C");
            loggedInUserContext.setActiveStatus(true);
            loggedInUserContext.setCurrentPage("Check Balance");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals("9800001003", loggedInUserContext.getAccountNumber());
    }

    @Test
    public void checkBalanceTest() {
        int balance = 50000;
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("9800001003");
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);

        Mockito.when(accountOperationDatabase.getBalance("9800001003")).thenReturn(balance);

        assertEquals(50000, accountOperationDatabase.getBalance(loggedInUserContext.getAccountNumber()));
    }

    @Test
    public void currentPageContextTest() {
        int balance = 50000;
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("9800001003");
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);
        Mockito.when(accountOperationDatabase.getBalance(loggedInUserContext.getAccountNumber())).thenReturn(balance);

        IAbstractAction checkBalanceAction = new CheckBalanceAction(accountOperationDatabase);
        checkBalanceAction.performAction();
        assertEquals("Check Balance", loggedInUserContext.getCurrentPage());
    }

}