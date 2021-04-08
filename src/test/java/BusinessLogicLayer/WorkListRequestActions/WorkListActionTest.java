package BusinessLogicLayer.WorkListRequestActions;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WorkListActionTest {

    @Test
    void returnToMainMenuTest() {
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setCurrentPage("Any Page");
        IWorkListRequest workListRequest = Mockito.mock(WorkListRequest.class);
        AbstractWorkListRequestAction workListAction = new WorkListChangeRequestAction(workListRequest, 1);

        workListAction.returnToMainMenu();

        assertEquals("", loggedInUserContext.getCurrentPage());
    }
}