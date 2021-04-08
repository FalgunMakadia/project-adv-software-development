package BusinessLogicLayer.WorkListActions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WorkListNewAccountRequestTest {

    @Test
    void processWorkList() {
        IWorkListAction workListChangeAction = Mockito.mock(WorkListNewAccountRequest.class);
        Mockito.doNothing().when(workListChangeAction).processWorkList();
        workListChangeAction.processWorkList();
        Mockito.verify(workListChangeAction, Mockito.times(1)).processWorkList();
    }
}