package BusinessLogicLayer.WorkListActions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class WorkListChangeActionTest {
    @Test
    void processWorkListTest() {
        IWorkListAction workListChangeAction = Mockito.mock(WorkListChangeAction.class);
        Mockito.doNothing().when(workListChangeAction).processWorkList();
        workListChangeAction.processWorkList();
        Mockito.verify(workListChangeAction, Mockito.times(1)).processWorkList();
    }
}