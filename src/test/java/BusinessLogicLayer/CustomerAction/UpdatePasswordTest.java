package BusinessLogicLayer.CustomerAction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UpdatePasswordTest {
    private UpdatePassword UpdatePassword;
    @BeforeEach
    void setup() {
        UpdatePassword = Mockito.mock(UpdatePassword.class);
    }

    @Test
    void performAction() {
        Mockito.doNothing().when(UpdatePassword).performAction();
        UpdatePassword.performAction();
        Mockito.verify(UpdatePassword, Mockito.times(1)).performAction();
    }
}

    

