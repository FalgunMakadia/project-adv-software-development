package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.CustomerProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PassPortNumberFieldCommandTest {
    AbstractFormCommand formCommand;

    @BeforeEach
    void executeTest() {
        IUserInterfacePage userInterface = Mockito.mock(IUserInterfacePage.class);
        Mockito.when(userInterface.getMandatoryUserInput("Enter Passport Number*: ")).thenReturn("test");
        formCommand = new PassPortNumberFieldCommand(new CustomerProfile(), userInterface);
        formCommand.execute();
    }

    @Test
    void getFieldValueTest() {
        assertEquals("test", formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        assertEquals("Passport Number", formCommand.getCommandLabel());
    }

}