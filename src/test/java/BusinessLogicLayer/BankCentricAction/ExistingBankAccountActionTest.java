package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAction;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ExistingBankAccountActionTest {

    @Test
    void getActionTitle() {
        ExistingBankAccountAction existingBankAccountAction = new ExistingBankAccountAction();
        assertEquals("Existing Bank Account", existingBankAccountAction.getActionTitle());
    }

    @Test
    void performActionTest() {
        IAction existingBankAccountAction = Mockito.mock(ExistingBankAccountAction.class);
        Mockito.doNothing().when(existingBankAccountAction).performAction();
        existingBankAccountAction.performAction();
        Mockito.verify(existingBankAccountAction, Mockito.times(1)).performAction();
    }
}