package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.ProfileDatabase.IProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.IUserProfileDatabase;
import DataAccessLayer.ProfileDatabase.ProfileDatabaseFactory;
import DataAccessLayer.ProfileDatabase.UserProfileDatabase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SaveNewAccountProfileFormActionCommandTest {

    @Test
    void execute() {
        IUserProfileDatabase userProfileDatabase = Mockito.mock(IUserProfileDatabase.class);
        Mockito.when(userProfileDatabase.addNewUser("sam","123","C")).thenReturn(0);
        AbstractProfile profile = Mockito.mock(AbstractProfile.class);
        Mockito.when(profile.generateDefaultPassword()).thenReturn(123);
        Mockito.when(profile.getUserName()).thenReturn("sam");
        Mockito.when(profile.getProfileRole()).thenReturn("C");
        IFormCommand formCommand = new SaveNewAccountProfileFormActionCommand(profile, userProfileDatabase);
        formCommand.execute();
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();

        assertEquals("",loggedInUserContext.getCurrentPage());
    }

    @Test
    void getFieldValueTest() {
        AbstractProfile profile = new CustomerProfile();
        IUserProfileDatabase userProfileDatabase = new UserProfileDatabase();
        IFormCommand formCommand = new SaveNewAccountProfileFormActionCommand(profile, userProfileDatabase);
        assertEquals("ACTION",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabelTest() {
        AbstractProfile profile = new CustomerProfile();
        IUserProfileDatabase userProfileDatabase = new UserProfileDatabase();
        IFormCommand formCommand = new SaveNewAccountProfileFormActionCommand(profile, userProfileDatabase);
        assertEquals("Save",formCommand.getCommandLabel());
    }
}