package BusinessLogicLayer.WorkListRequestActions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WorkListNewAccountRequestTest {

    @Test
    void processWorkList() {
        IWorkListRequestAction workListChangeAction = Mockito.mock(WorkListNewAccountRequestAction.class);
        Mockito.doNothing().when(workListChangeAction).processWorkList();
        workListChangeAction.processWorkList();
        Mockito.verify(workListChangeAction, Mockito.times(1)).processWorkList();
    }
}