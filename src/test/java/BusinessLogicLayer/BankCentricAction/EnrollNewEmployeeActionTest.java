package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class EnrollNewEmployeeActionTest {

    @Test
    void getActionTitleTest() {
        EnrollNewEmployeeAction enrollNewEmployeeAction = new EnrollNewEmployeeAction();
        assertEquals("Enroll New Employee",enrollNewEmployeeAction.getActionTitle());
    }

    @Test
    void performActionTest(){
        IAbstractAction enrollNewEmployeeAction = Mockito.mock(EnrollNewEmployeeAction.class);
        Mockito.doNothing().when(enrollNewEmployeeAction).performAction();
        enrollNewEmployeeAction.performAction();
        Mockito.verify(enrollNewEmployeeAction, Mockito.times(1)).performAction();
    }

    @Test
    void currentPageTest(){
        LoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        EnrollNewEmployeeAction enrollNewEmployeeAction  = new EnrollNewEmployeeAction(new LinkedHashMap<>(), new LinkedHashMap<>());
        enrollNewEmployeeAction.performAction();

        assertEquals("Enroll New Employee", loggedInUserContext.getCurrentPage());
    }
}