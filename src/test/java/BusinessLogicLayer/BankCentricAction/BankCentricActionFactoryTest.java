package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankCentricActionFactoryTest {

    @Test
    void createEnrollNewEmployeeActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAbstractAction enrollNewEmployeeAction = bankCentricActionFactory.createEnrollNewEmployeeAction();
        assertEquals("Enroll New Employee", enrollNewEmployeeAction.getActionTitle());
    }

    @Test
    void createExistingBankAccountActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAbstractAction existingBankAccountAction = bankCentricActionFactory.createExistingBankAccountAction();
        assertEquals("Existing Bank Account", existingBankAccountAction.getActionTitle());
    }

    @Test
    void createOpenNewAccountActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAbstractAction openNewAccountAction = bankCentricActionFactory.createOpenNewAccountAction();
        assertEquals("Open New Account", openNewAccountAction.getActionTitle());
    }

    @Test
    void createWorkListActionTest() {
        BankCentricActionFactory bankCentricActionFactory = new BankCentricActionFactory();
        IAbstractAction workListAction = bankCentricActionFactory.createWorkListAction();
        assertEquals("WorkList", workListAction.getActionTitle());
    }
}