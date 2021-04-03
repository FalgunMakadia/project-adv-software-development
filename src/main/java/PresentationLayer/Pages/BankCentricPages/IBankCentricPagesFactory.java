package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public interface IBankCentricPagesFactory {
    IPage createUserDetailPage(ProfileAbstract profile);

    IPage createWorkListTable(Map<Integer, WorklistRequest> workListRequestMap);
}
