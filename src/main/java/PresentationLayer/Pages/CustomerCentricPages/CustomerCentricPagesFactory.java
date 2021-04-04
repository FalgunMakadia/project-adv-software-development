package PresentationLayer.Pages.CustomerCentricPages;

import BusinessLogicLayer.TransactionAction.TransactionModel;
import PresentationLayer.Pages.IPage;

import java.util.ArrayList;

public class CustomerCentricPagesFactory implements ICustomerCentricPagesFactory{
    @Override
    public IPage createBankStatementTable(ArrayList<TransactionModel> transactionList) {
        return new BankStatementTablePage(transactionList);
    }
}
