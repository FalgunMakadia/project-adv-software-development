package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListActions.IWorkListRequest;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public interface IBankCentricPagesFactory {
    IPage createUserDetailPage(AbstractProfile profile);

    IPage createWorkListTable(Map<Integer, IWorkListRequest> workListRequestMap);
}
