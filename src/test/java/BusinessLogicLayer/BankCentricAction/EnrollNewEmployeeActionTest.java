package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;

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
        LoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        EnrollNewEmployeeAction enrollNewEmployeeAction  = new EnrollNewEmployeeAction(new LinkedHashMap<>(), new LinkedHashMap<>());
        enrollNewEmployeeAction.performAction();

        assertEquals("Enroll New Employee", loggedInUserContext.getCurrentPage());
    }
}