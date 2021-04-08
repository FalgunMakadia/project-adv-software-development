package BusinessLogicLayer.Transaction;

import DataAccessLayer.OperationDatabase.AccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;
import DataAccessLayer.ProfileDatabase.UserProfileDatabase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.CommonAction.SignInAction;
import BusinessLogicLayer.TransactionAction.TransferAction;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.SQLException;

public class TransferActionTest {

    private TransferAction transferAction;
    
    
    @Test
    void getActionTitleTest() {
        transferAction = new TransferAction();
        assertEquals("Transfer",transferAction.getActionTitle());
    }

    @Test
    void getActionTitleFailTest() {
        transferAction = new TransferAction();
        assertNotEquals("Deposit",transferAction.getActionTitle());
    }

    @Test
    void performActionTest(){
        IAction transferAction = Mockito.mock(TransferAction.class);
        Mockito.doNothing().when(transferAction).performAction();
        transferAction.performAction();
        Mockito.verify(transferAction, Mockito.times(1)).performAction();
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
    public void TransactionTest() {
        String targetAccountNumber="9800001000";
        int originAccountPreviousBalance=80000;
        int targetAccountPreviousBalance=50000;
        int transferAmount=40000;
        int originAccountFinalBalance=originAccountPreviousBalance-transferAmount;
        int targetAccountFinalBalance=targetAccountPreviousBalance+transferAmount;
        //int finalBalance=originAccountFinalBalance;
        
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("9800001003");
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);
        Mockito.when(accountOperationDatabase.updateBalance(originAccountFinalBalance, loggedInUserContext.getAccountNumber())).thenReturn(originAccountFinalBalance);
        assertEquals(originAccountFinalBalance, accountOperationDatabase.updateBalance(originAccountFinalBalance,loggedInUserContext.getAccountNumber()));
        Mockito.when(accountOperationDatabase.updateBalance(targetAccountFinalBalance, targetAccountNumber)).thenReturn(targetAccountFinalBalance);
        assertEquals(targetAccountFinalBalance, accountOperationDatabase.updateBalance(targetAccountFinalBalance,targetAccountNumber));
    
    }


}