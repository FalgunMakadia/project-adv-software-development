package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.CustomerProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProvinceFieldCommandTest {
    AbstractFormCommand formCommand;
    @BeforeEach
    void executeTest() {
        IUserInterfacePage userInterface = Mockito.mock(IUserInterfacePage.class);
        Mockito.when(userInterface.getMandatoryUserInput("Enter Province*: ")).thenReturn("test");
        formCommand = new ProvinceFieldCommand(new CustomerProfile(), userInterface);
        formCommand.execute();
    }

    @Test
    void getFieldValueTest() {
        assertEquals("test",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        assertEquals("Province",formCommand.getCommandLabel());
    }

}