package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequest;
import PresentationLayer.Pages.IAbstractPage;

import java.util.Map;

public class BankCentricPagesFactory implements IBankCentricPagesFactory {
    @Override
    public IAbstractPage createUserDetailPage(AbstractProfile profile) {
        return new UserDetailPage(profile);
    }

    @Override
    public IAbstractPage createWorkListTable(Map<Integer, IWorkListRequest> workListRequestMap) {
        return new WorkListTablePage(workListRequestMap);
    }
}
