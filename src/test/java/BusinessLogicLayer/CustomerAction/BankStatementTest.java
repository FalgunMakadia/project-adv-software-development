package BusinessLogicLayer.CustomerAction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BankStatementTest {

    private BankStatement bankStatement;

    @BeforeEach
    void setup() {
        bankStatement = Mockito.mock(BankStatement.class);
    }

    @Test
    void performAction() {
        Mockito.doNothing().when(bankStatement).performAction();
        bankStatement.performAction();
        Mockito.verify(bankStatement, Mockito.times(1)).performAction();
    }
}