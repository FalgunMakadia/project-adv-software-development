package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class WorkListActionTest {

    @Test
    void getActionTitleTest() {
        IAbstractAction workListAction = new WorkListAction();
        assertEquals("WorkList",workListAction.getActionTitle());
    }

    @Test
    void performActionTest() {
        IAbstractAction workListAction = Mockito.mock(WorkListAction.class);
        Mockito.doNothing().when(workListAction).performAction();
        workListAction.performAction();
        Mockito.verify(workListAction, Mockito.times(1)).performAction();
    }

    @Test
    void currentPageTest(){
        IAbstractAction workListAction = new WorkListAction();
        LoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        assertEquals("WorkList", loggedInUserContext.getCurrentPage());
    }
}