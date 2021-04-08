package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.TransactionAction.TransactionModel;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.OperationDatabase.AccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankStatementActionTest {

    private BankStatementAction bankStatementAction;

    @BeforeEach
    void setup() {
        bankStatementAction = Mockito.mock(BankStatementAction.class);
    }

    @Test
    void getActionTitleTest() {
        IAction bankStatementAction = new BankStatementAction();
        assertEquals("Bank Statement", bankStatementAction.getActionTitle());
    }

    @Test
    void performAction() {
        Mockito.doNothing().when(bankStatementAction).performAction();
        bankStatementAction.performAction();
        Mockito.verify(bankStatementAction, Mockito.times(1)).performAction();
    }

    @Test
    void currentPageContextTest() {
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);
        ArrayList<TransactionModel> transactionList = new ArrayList<>();
        Mockito.when(accountOperationDatabase.getMiniStatement(Mockito.anyString())).thenReturn(transactionList);

        IAction bankStatementAction = new BankStatementAction(accountOperationDatabase);

        bankStatementAction.performAction();

        assertEquals("Bank Statement", loggedInUserContext.getCurrentPage());
    }

    @Test
    void printTrasactionTest() {
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("111111");
        IAccountOperationDatabase accountOperationDatabase = Mockito.mock(AccountOperationDatabase.class);

        ArrayList<TransactionModel> transactionList = new ArrayList<TransactionModel>(){
            {
                add(new TransactionModel("111111", "Dr", 999, "2021-02-02"));
                add(new TransactionModel("111111", "Cr", 9999, "2021-03-02"));
            }
        };


        Mockito.when(accountOperationDatabase.getMiniStatement("111111")).thenReturn(transactionList);

        assertEquals(2, transactionList.size());

        Mockito.when(accountOperationDatabase.getMiniStatement("222222")).thenReturn(transactionList = new ArrayList<>());

        assertEquals(0, transactionList.size());

        IAction bankStatementAction = new BankStatementAction(accountOperationDatabase);

        bankStatementAction.performAction();
    }
}