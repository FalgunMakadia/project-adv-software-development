package BusinessLogicLayer.ProfileForm.ProfileFormAction;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IFormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.OperationDatabase.IWorklistOperationDatabase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SaveUpdatedPersonalDetailFormActionCommandTest {

    @Test
    void execute() {
        IWorklistOperationDatabase workListOperationDatabase = Mockito.mock(IWorklistOperationDatabase.class);
        Mockito.when(workListOperationDatabase.addWorkListRequest(null)).thenReturn(0);
        AbstractProfile profile = Mockito.mock(AbstractProfile.class);
        Mockito.when(profile.generateDefaultPassword()).thenReturn(123);
        Mockito.when(profile.getUserName()).thenReturn("sam");
        Mockito.when(profile.getProfileRole()).thenReturn("C");
        IFormCommand formCommand = new SaveUpdatedPersonalDetailFormActionCommand(null, workListOperationDatabase);
        formCommand.execute();
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();

        assertEquals("",loggedInUserContext.getCurrentPage());

    }

    @Test
    void getFieldValue() {
        IWorklistOperationDatabase workListOperationDatabase = Mockito.mock(IWorklistOperationDatabase.class);
        Mockito.when(workListOperationDatabase.addWorkListRequest(null)).thenReturn(0);
        AbstractProfile profile = Mockito.mock(AbstractProfile.class);
        Mockito.when(profile.generateDefaultPassword()).thenReturn(123);
        Mockito.when(profile.getUserName()).thenReturn("sam");
        Mockito.when(profile.getProfileRole()).thenReturn("C");
        IFormCommand formCommand = new SaveUpdatedPersonalDetailFormActionCommand(null, workListOperationDatabase);

        assertEquals("ACTION",formCommand.getFieldValue());

    }

    @Test
    void getCommandLabel() {
        IWorklistOperationDatabase workListOperationDatabase = Mockito.mock(IWorklistOperationDatabase.class);
        Mockito.when(workListOperationDatabase.addWorkListRequest(null)).thenReturn(0);
        AbstractProfile profile = Mockito.mock(AbstractProfile.class);
        Mockito.when(profile.generateDefaultPassword()).thenReturn(123);
        Mockito.when(profile.getUserName()).thenReturn("sam");
        Mockito.when(profile.getProfileRole()).thenReturn("C");
        IFormCommand formCommand = new SaveUpdatedPersonalDetailFormActionCommand(null, workListOperationDatabase);

        assertEquals("Save",formCommand.getCommandLabel());
    }
}