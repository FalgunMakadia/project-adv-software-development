package BusinessLogicLayer.Transaction;

import DataAccessLayer.OperationDatabase.AccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;
import DataAccessLayer.ProfileDatabase.UserProfileDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.CommonAction.SignInAction;
import BusinessLogicLayer.TransactionAction.DepositAction;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;

import static org.mockito.Mockito.doAnswer;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositActionTest {
    private DepositAction depositAction;

    @BeforeEach
    public void setup() {
        depositAction = Mockito.mock(DepositAction.class);
    }

    @Test
    void getActionTitleTest() {
        DepositAction depositActionTest = new DepositAction();
        assertEquals("Deposit", depositActionTest.getActionTitle());
    }

    @Test
    void getActionTitleFailTest() {
        DepositAction depositActionTest = new DepositAction();
        assertNotEquals("Withdraw", depositActionTest.getActionTitle());
    }

    @Test
    void performActionTest() {
        IAbstractAction depositAction = Mockito.mock(DepositAction.class);
        Mockito.doNothing().when(depositAction).performAction();
        depositAction.performAction();
        Mockito.verify(depositAction, Mockito.times(1)).performAction();
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
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");
        assertEquals("9800001003", loggedInUserContext.getAccountNumber());
    }

    @Test
    public void validateAccountNumberFailTest() {
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
            loggedInUserContext.setCurrentPage("Test");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");
        assertNotEquals("9800001000", loggedInUserContext.getAccountNumber());
    }

    @Test
    public void DepositTest() {
        int balance = 80000;
        int depositAmount = 10000;
        int finalBalance = balance + depositAmount;
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("9800001003");
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);
        Mockito.when(accountOperationDatabase.updateBalance(finalBalance, loggedInUserContext.getAccountNumber())).thenReturn(finalBalance);
        assertEquals(finalBalance, accountOperationDatabase.updateBalance(finalBalance, loggedInUserContext.getAccountNumber()));
    }
}