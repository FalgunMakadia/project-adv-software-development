package PresentationLayer;


import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;
import PresentationLayer.MenuRouting.IMenuRoutingFactory;
import PresentationLayer.Pages.BankCentricPages.IBankCentricPagesFactory;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CommonPages.ILoginPage;
import PresentationLayer.Pages.CustomerCentricPages.IBankStatementTablePage;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

import PresentationLayer.Pages.CustomerCentricPages.ICustomerCentricPagesFactory;
import PresentationLayer.Pages.IPage;
import PresentationLayer.MenuRouting.IMenuRoutingCommand;
import PresentationLayer.Pages.CommonPages.IUserFormPage;

import java.util.Map;

public interface IPresentationFactory {

    IMenuRoutingFactory createMenuRoutingFactory();

    IBankCentricPagesFactory createBankCentricPagesFactory();

    ICommonPagesFactory createCommonPagesFactory();

    ICustomerCentricPagesFactory createCustomerCentricPagesFactory();
}
