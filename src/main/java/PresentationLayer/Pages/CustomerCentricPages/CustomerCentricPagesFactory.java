package PresentationLayer.Pages.CustomerCentricPages;

public class CustomerCentricPagesFactory implements ICustomerCentricPagesFactory{
    @Override
    public IBankStatementTablePage createBankStatementTable() {
        return new BankStatementTablePage();
    }
}
