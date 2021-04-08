package PresentationLayer.Pages.CustomerCentricPages;

import BusinessLogicLayer.TransactionAction.ITransactionModel;
import PresentationLayer.Pages.IAbstractPage;

import java.util.ArrayList;

public class CustomerCentricPagesFactory implements ICustomerCentricPagesFactory {
    @Override
    public IAbstractPage createBankStatementTable(ArrayList<ITransactionModel> transactionList) {
        return new BankStatementTablePage(transactionList);
    }
}
