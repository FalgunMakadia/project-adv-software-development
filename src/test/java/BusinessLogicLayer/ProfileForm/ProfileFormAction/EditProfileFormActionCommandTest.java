package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditProfileFormActionCommandTest {

    @Test
    void getFieldValueTest() {
        IFormCommand formCommand = new EditProfileFormActionCommand(null,null);
        assertEquals("ACTION",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        IFormCommand formCommand = new EditProfileFormActionCommand(null,null);
        assertEquals("Edit",formCommand.getCommandLabel());
    }

}