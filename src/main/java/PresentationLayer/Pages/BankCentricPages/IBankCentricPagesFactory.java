package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorkListActions.IWorkListRequest;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public interface IBankCentricPagesFactory {
    IPage createUserDetailPage(ProfileAbstract profile);

    IPage createWorkListTable(Map<Integer, IWorkListRequest> workListRequestMap);
}
