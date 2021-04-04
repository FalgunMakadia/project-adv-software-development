package BusinessLogicLayer.CustomerCentricAction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BankStatementActionTest {

    private BankStatementAction bankStatementAction;

    @BeforeEach
    void setup() {
        bankStatementAction = Mockito.mock(BankStatementAction.class);
    }

    @Test
    void performAction() {
        Mockito.doNothing().when(bankStatementAction).performAction();
        bankStatementAction.performAction();
        Mockito.verify(bankStatementAction, Mockito.times(1)).performAction();
    }
}