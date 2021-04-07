package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankCentricActionFactoryTest {

    @Test
    void createEnrollNewEmployeeActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAction enrollNewEmployeeAction = bankCentricActionFactory.createEnrollNewEmployeeAction();
        assertEquals("Enroll New Employee", enrollNewEmployeeAction.getActionTitle());
    }

    @Test
    void createExistingBankAccountActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAction existingBankAccountAction = bankCentricActionFactory.createExistingBankAccountAction();
        assertEquals("Existing Bank Account", existingBankAccountAction.getActionTitle());
    }

    @Test
    void createOpenNewAccountActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAction openNewAccountAction = bankCentricActionFactory.createOpenNewAccountAction();
        assertEquals("Open New Account", openNewAccountAction.getActionTitle());
    }

    @Test
    void createWorkListActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAction workListAction = bankCentricActionFactory.createWorkListAction();
        assertEquals("WorkList", workListAction.getActionTitle());
    }
}