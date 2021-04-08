package PresentationLayer;


import PresentationLayer.MenuRouting.IMenuRoutingFactory;
import PresentationLayer.Pages.BankCentricPages.IBankCentricPagesFactory;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;

import PresentationLayer.Pages.CustomerCentricPages.ICustomerCentricPagesFactory;

public interface IPresentationFactory {

    IMenuRoutingFactory createMenuRoutingFactory();

    IBankCentricPagesFactory createBankCentricPagesFactory();

    ICommonPagesFactory createCommonPagesFactory();

    ICustomerCentricPagesFactory createCustomerCentricPagesFactory();
}
