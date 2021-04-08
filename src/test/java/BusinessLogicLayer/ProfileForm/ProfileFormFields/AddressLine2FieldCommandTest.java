package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.CustomerProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AddressLine2FieldCommandTest {
    AbstractFormCommand formCommand;

    @BeforeEach
    void executeTest() {
        IUserInterfacePage userInterface = Mockito.mock(IUserInterfacePage.class);
        Mockito.when(userInterface.getUserInput("Enter Address Line 2: ")).thenReturn("test");
        formCommand = new AddressLine2FieldCommand(new CustomerProfile(), userInterface);
        formCommand.execute();
    }

    @Test
    void getFieldValueTest() {
        assertEquals("test", formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        assertEquals("Address Line 2", formCommand.getCommandLabel());
    }

}