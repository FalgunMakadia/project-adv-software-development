package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DOBCommandTest {
    String date1;
    String date2;
    String date3;

    DOBCommand dobCommand;

    @BeforeEach
    void setup() {
        dobCommand = new DOBCommand(new Customer());
        date1 = "10/09/1997";
        date2 = "2000-30-09";
        date3 = "2020-03-21";
    }

    @Test
    void dateValidator() {
        assertTrue(dobCommand.validateBirthDate(date1));
        assertTrue(dobCommand.validateBirthDate(date2));
        assertFalse(dobCommand.validateBirthDate(date3));
    }
}