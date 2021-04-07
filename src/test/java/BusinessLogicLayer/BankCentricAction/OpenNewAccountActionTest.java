package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class OpenNewAccountActionTest {

    @Test
    void getActionTitleTest() {
        OpenNewAccountAction openNewAccountAction = new OpenNewAccountAction();
        assertEquals("Open New Account", openNewAccountAction.getActionTitle());
    }

    @Test
    void performActionTest() {
        IAction openNewAccountAction = Mockito.mock(OpenNewAccountAction.class);
        Mockito.doNothing().when(openNewAccountAction).performAction();
        openNewAccountAction.performAction();

        Mockito.verify(openNewAccountAction, Mockito.times(1)).performAction();
    }

    @Test
    void currentPageTest() {
        LoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        OpenNewAccountAction openNewAccountAction = new OpenNewAccountAction(new LinkedHashMap<>(), new LinkedHashMap<>());
        openNewAccountAction.performAction();

        assertEquals("Open New Account", loggedInUserContext.getCurrentPage());
    }

}