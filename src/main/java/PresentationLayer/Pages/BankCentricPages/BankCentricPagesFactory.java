package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListActions.IWorkListRequest;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public class BankCentricPagesFactory implements IBankCentricPagesFactory{
    @Override
    public IPage createUserDetailPage(AbstractProfile profile) {
        return new UserDetailPage(profile);
    }

    @Override
    public IPage createWorkListTable(Map<Integer, IWorkListRequest> workListRequestMap) {
        return new WorkListTablePage(workListRequestMap);
    }
}
