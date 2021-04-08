package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditProfileFormActionCommandTest {

    @Test
    void getFieldValueTest() {
        IAbstractFormCommand formCommand = new EditProfileFormActionCommand(null,null);
        assertEquals("ACTION",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        IAbstractFormCommand formCommand = new EditProfileFormActionCommand(null,null);
        assertEquals("Edit",formCommand.getCommandLabel());
    }

}