package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.CustomerCentricAction.UpdatePersonalDetailAction;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WorkListActionTest {

    @Test
    void getActionTitleTest() {
        IAction workListAction = new WorkListAction();
        assertEquals("WorkList",workListAction.getActionTitle());
    }

    @Test
    void performActionTest() {
        IAction workListAction = Mockito.mock(WorkListAction.class);
        Mockito.doNothing().when(workListAction).performAction();
        workListAction.performAction();
        Mockito.verify(workListAction, Mockito.times(1)).performAction();
    }

    @Test
    void currentPageTest(){
        IAction workListAction = new WorkListAction();
        LoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        assertEquals("WorkList", loggedInUserContext.getCurrentPage());

    }
}