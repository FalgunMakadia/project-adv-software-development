package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import DataAccessLayer.ProfileDatabase.CustomerProfileDatabase;
import DataAccessLayer.ProfileDatabase.ICustomerProfileDatabase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdatePersonalDetailActionTest {

    @Test
    void performAction() {
        IAbstractAction updatePersonalDetailAction = Mockito.mock(UpdatePersonalDetailAction.class);
        Mockito.doNothing().when(updatePersonalDetailAction).performAction();
        updatePersonalDetailAction.performAction();
        Mockito.verify(updatePersonalDetailAction, Mockito.times(1)).performAction();
    }

    @Test
    void getActionTitleTest() {
        IAbstractAction updatePersonalDetailAction = new UpdatePersonalDetailAction();
        assertEquals("Update Personal Details", updatePersonalDetailAction.getActionTitle());
    }

    @Test
    void currentPageTest() {
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber(null);
        ICustomerProfileDatabase customerProfileDatabase = Mockito.mock(CustomerProfileDatabase.class);

        Mockito.doAnswer((arguments)->{
            if(arguments.getArgument(0).equals("111222333")) {
                return Mockito.mock(AbstractProfile.class);
            } else {
                return null;
            }
        }).when(customerProfileDatabase).getCustomerProfile(Mockito.anyString());

        IAbstractAction updatePersonalDetailAction = new UpdatePersonalDetailAction(customerProfileDatabase);

        updatePersonalDetailAction.performAction();

        assertEquals("Update Personal Details", loggedInUserContext.getCurrentPage());
    }

    @Test
    void checkCustomerDetailTest() {
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setAccountNumber("123456653");
        ICustomerProfileDatabase customerProfileDatabase = Mockito.mock(CustomerProfileDatabase.class);

        Mockito.doAnswer((arguments)->{
            assertEquals(arguments.getArgument(0), "123456653");
            return null;
        }).when(customerProfileDatabase).getCustomerProfile(Mockito.anyString());

        IAbstractAction updatePersonalDetailAction = new UpdatePersonalDetailAction(customerProfileDatabase);

        updatePersonalDetailAction.performAction();
    }
}