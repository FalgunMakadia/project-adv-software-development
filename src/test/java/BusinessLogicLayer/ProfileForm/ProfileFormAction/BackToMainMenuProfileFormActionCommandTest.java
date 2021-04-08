package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackToMainMenuProfileFormActionCommandTest {

    @Test
    void executeTest() {
        IAbstractFormCommand formCommand = new BackToMainMenuProfileFormActionCommand();
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        formCommand.execute();
        assertEquals("",loggedInUserContext.getCurrentPage());
    }

    @Test
    void getFieldValueTest() {
        IAbstractFormCommand formCommand = new BackToMainMenuProfileFormActionCommand();
        assertEquals("ACTION",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        IAbstractFormCommand formCommand = new BackToMainMenuProfileFormActionCommand();
        assertEquals("Back to Main Menu",formCommand.getCommandLabel());
    }
}