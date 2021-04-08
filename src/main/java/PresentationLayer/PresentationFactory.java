package PresentationLayer;

import PresentationLayer.MenuRouting.IMenuRoutingFactory;
import PresentationLayer.MenuRouting.MenuRoutingFactory;
import PresentationLayer.Pages.BankCentricPages.BankCentricPagesFactory;
import PresentationLayer.Pages.BankCentricPages.IBankCentricPagesFactory;
import PresentationLayer.Pages.CommonPages.CommonPagesFactory;
import PresentationLayer.Pages.CommonPages.ICommonPagesFactory;
import PresentationLayer.Pages.CustomerCentricPages.CustomerCentricPagesFactory;
import PresentationLayer.Pages.CustomerCentricPages.ICustomerCentricPagesFactory;

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
