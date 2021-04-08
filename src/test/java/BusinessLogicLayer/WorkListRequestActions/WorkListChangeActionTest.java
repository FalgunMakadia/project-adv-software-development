package BusinessLogicLayer.WorkListRequestActions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class WorkListChangeActionTest {
    @Test
    void processWorkListTest() {
        IWorkListRequestAction workListChangeAction = Mockito.mock(WorkListChangeRequestAction.class);
        Mockito.doNothing().when(workListChangeAction).processWorkList();
        workListChangeAction.processWorkList();
        Mockito.verify(workListChangeAction, Mockito.times(1)).processWorkList();
    }
}