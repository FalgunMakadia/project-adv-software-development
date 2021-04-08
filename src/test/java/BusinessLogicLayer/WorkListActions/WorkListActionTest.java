package BusinessLogicLayer.WorkListActions;

import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.Pages.CommonPages.UserInterfacePage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WorkListActionTest {

    @Test
    void returnToMainMenuTest() {
        ILoggedInUserContext loggedInUserContext = LoggedInUserContext.instance();
        loggedInUserContext.setCurrentPage("Any Page");
        IWorkListRequest workListRequest = Mockito.mock(WorkListRequest.class);
        WorkListAction workListAction = new WorkListChangeAction(workListRequest, 1);

        workListAction.returnToMainMenu();

        assertEquals("", loggedInUserContext.getCurrentPage());
    }
}