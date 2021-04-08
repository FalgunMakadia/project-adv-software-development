package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackToMainMenuProfileFormActionCommandTest {

    @Test
    void executeTest() {
        IFormCommand formCommand = new BackToMainMenuProfileFormActionCommand();
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        formCommand.execute();
        assertEquals("",loggedInUserContext.getCurrentPage());
    }

    @Test
    void getFieldValueTest() {
        IFormCommand formCommand = new BackToMainMenuProfileFormActionCommand();
        assertEquals("ACTION",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        IFormCommand formCommand = new BackToMainMenuProfileFormActionCommand();
        assertEquals("Back to Main Menu",formCommand.getCommandLabel());
    }
}