package PresentationLayer;

import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import PresentationLayer.MenuRouting.IMenuRoutingFactory;
import PresentationLayer.MenuRouting.MenuRoutingFactory;
import PresentationLayer.Pages.BankCentricPages.BankCentricPagesFactory;
import PresentationLayer.Pages.BankCentricPages.IBankCentricPagesFactory;
import PresentationLayer.Pages.BankCentricPages.UserDetailPage;
import PresentationLayer.Pages.BankCentricPages.WorkListTablePage;
import PresentationLayer.Pages.CommonPages.*;
import PresentationLayer.Pages.CustomerCentricPages.BankStatementTablePage;
import PresentationLayer.Pages.CustomerCentricPages.CustomerCentricPagesFactory;
import PresentationLayer.Pages.CustomerCentricPages.IBankStatementTablePage;
import PresentationLayer.MenuRouting.ExistingBankAccountMenuRoutingCommand;
import PresentationLayer.MenuRouting.IMenuRoutingCommand;
import PresentationLayer.Pages.CustomerCentricPages.ICustomerCentricPagesFactory;
import PresentationLayer.Pages.IPage;

import java.util.Map;

public class PresentationFactory implements IPresentationFactory {
    @Override
    public IMenuRoutingFactory createMenuRoutingFactory() {
        return new MenuRoutingFactory();
    }

    @Override
    public IBankCentricPagesFactory createBankCentricPagesFactory() {
        return new BankCentricPagesFactory();
    }

    @Override
    public ICommonPagesFactory createCommonPagesFactory() {
        return new CommonPagesFactory();
    }

    @Override
    public ICustomerCentricPagesFactory createCustomerCentricPagesFactory() {
        return new CustomerCentricPagesFactory();
    }
}
