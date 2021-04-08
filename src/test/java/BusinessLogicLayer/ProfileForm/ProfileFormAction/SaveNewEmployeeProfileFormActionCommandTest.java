package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.ProfileDatabase.IEmployeeProfileDatabase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SaveNewEmployeeProfileFormActionCommandTest {

    @Test
    void execute() {
        IEmployeeProfileDatabase userProfileDatabase = Mockito.mock(IEmployeeProfileDatabase.class);
        Mockito.when(userProfileDatabase.addNewBankEmployeeProfile(null)).thenReturn(0);
        AbstractProfile profile = Mockito.mock(AbstractProfile.class);
        Mockito.when(profile.generateDefaultPassword()).thenReturn(123);
        Mockito.when(profile.getUserName()).thenReturn("sam");
        Mockito.when(profile.getProfileRole()).thenReturn("C");
        IAbstractFormCommand formCommand = new SaveNewEmployeeProfileFormActionCommand(profile, userProfileDatabase);
        formCommand.execute();
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();

        assertEquals("",loggedInUserContext.getCurrentPage());

    }

    @Test
    void getFieldValue() {
        IEmployeeProfileDatabase userProfileDatabase = Mockito.mock(IEmployeeProfileDatabase.class);
        Mockito.when(userProfileDatabase.addNewBankEmployeeProfile(null)).thenReturn(0);
        AbstractProfile profile = Mockito.mock(AbstractProfile.class);
        Mockito.when(profile.generateDefaultPassword()).thenReturn(123);
        Mockito.when(profile.getUserName()).thenReturn("sam");
        Mockito.when(profile.getProfileRole()).thenReturn("C");
        IAbstractFormCommand formCommand = new SaveNewEmployeeProfileFormActionCommand(profile, userProfileDatabase);
        assertEquals("ACTION",formCommand.getFieldValue());
    }

    @Test
    void getCommandLabel() {
        IEmployeeProfileDatabase userProfileDatabase = Mockito.mock(IEmployeeProfileDatabase.class);
        Mockito.when(userProfileDatabase.addNewBankEmployeeProfile(null)).thenReturn(0);
        AbstractProfile profile = Mockito.mock(AbstractProfile.class);
        Mockito.when(profile.generateDefaultPassword()).thenReturn(123);
        Mockito.when(profile.getUserName()).thenReturn("sam");
        Mockito.when(profile.getProfileRole()).thenReturn("C");
        IAbstractFormCommand formCommand = new SaveNewEmployeeProfileFormActionCommand(profile, userProfileDatabase);
        assertEquals("ACTION",formCommand.getFieldValue());

    }
}