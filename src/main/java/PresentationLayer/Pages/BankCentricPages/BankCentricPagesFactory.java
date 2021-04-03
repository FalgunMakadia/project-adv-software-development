package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public class BankCentricPagesFactory implements IBankCentricPagesFactory{
    @Override
    public IPage createUserDetailPage(ProfileAbstract profile) {
        return new UserDetailPage(profile);
    }

    @Override
    public IPage createWorkListTable(Map<Integer, WorklistRequest> workListRequestMap) {
        return new WorkListTablePage(workListRequestMap);
    }
}
