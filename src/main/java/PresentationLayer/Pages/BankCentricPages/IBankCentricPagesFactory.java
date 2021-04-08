package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.WorkListRequestActions.IWorkListRequest;
import PresentationLayer.Pages.IAbstractPage;

import java.util.Map;

public interface IBankCentricPagesFactory {
    IAbstractPage createUserDetailPage(AbstractProfile profile);

    IAbstractPage createWorkListTable(Map<Integer, IWorkListRequest> workListRequestMap);
}