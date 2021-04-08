package BusinessLogicLayer.Transaction;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.CommonAction.SignInAction;
import BusinessLogicLayer.TransactionAction.WithdrawAction;
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

public class WithdrawActionTest {

    private WithdrawAction withdrawAction;

    @BeforeEach
    public void setup() {
        withdrawAction = Mockito.mock(WithdrawAction.class);
    }

    @Test
    void getActionTitleTest() {
        IAbstractAction withdrawAction = new WithdrawAction();
        assertEquals("Withdraw", withdrawAction.getActionTitle());
    }

    @Test
    void performAction() {
        Mockito.doNothing().when(withdrawAction).performAction();
        withdrawAction.performAction();
        Mockito.verify(withdrawAction, Mockito.times(1)).performAction();
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
            loggedInUserContext.setCurrentPage("Withdraw");
            loggedInUserContext.setParentPage("TestParent");
            return null;
        }).when(userProfileDatabase).validateUser(userName, password);
        SignInAction signInAction = new SignInAction(userProfileDatabase);
        signInAction.validateUser("sam", "1qaz2wsx");

        assertEquals("9800001003", loggedInUserContext.getAccountNumber());
    }

    @Test
    public void withdrawTest() {
        int balance = 70000;
        int withdrawAmount = 10000;
        int finalBalance = balance - withdrawAmount;

        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("9800001003");
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);
        Mockito.when(accountOperationDatabase.updateBalance(finalBalance,loggedInUserContext.getAccountNumber())).thenReturn(finalBalance);

        assertEquals(finalBalance, accountOperationDatabase.updateBalance(finalBalance,loggedInUserContext.getAccountNumber()));
    }

    @Test
    public void currentPageContextTest() {
        int balance = 70000;
        int withdrawAmount = 10000;
        int finalBalance = balance - withdrawAmount;

        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("9800001003");
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);
        Mockito.when(accountOperationDatabase.updateBalance(finalBalance, loggedInUserContext.getAccountNumber())).thenReturn(finalBalance);

        assertEquals("Withdraw", loggedInUserContext.getCurrentPage());
    }

}
