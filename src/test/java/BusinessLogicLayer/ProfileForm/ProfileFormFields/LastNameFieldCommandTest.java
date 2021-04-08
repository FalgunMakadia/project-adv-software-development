package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.CustomerProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LastNameFieldCommandTest {
    AbstractFormCommand formCommand;
    @BeforeEach
    void executeTest() {
        IUserInterfacePage userInterface = Mockito.mock(IUserInterfacePage.class);
        Mockito.when(userInterface.getMandatoryUserInput("Enter Last Name*: ")).thenReturn("test");
        formCommand = new LastNameFieldCommand(new CustomerProfile(), userInterface);
        formCommand.execute();
    }

    @Test
    void getFieldValueTest() {
        assertEquals("test",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        assertEquals("Last Name",formCommand.getCommandLabel());
    }

}