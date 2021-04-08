package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.AbstractFormCommand;
import BusinessLogicLayer.User.CustomerProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DateOfBirthFieldCommandTest {
    AbstractFormCommand formCommand;

    @BeforeEach
    void executeTest() {
        IUserInterfacePage userInterface = Mockito.mock(IUserInterfacePage.class);
        Mockito.when(userInterface.getMandatoryUserInput("Enter DOB(YYYY-MM-DD)*: ")).thenReturn("1311-12-12");
        formCommand = new DateOfBirthFieldCommand(new CustomerProfile(), userInterface);
        formCommand.execute();
    }

    @Test
    void getFieldValueTest() {
        assertEquals("1311-12-12", formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        assertEquals("Date Of Birth", formCommand.getCommandLabel());
    }

}