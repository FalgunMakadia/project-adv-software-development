package PresentationLayer.Pages.CustomerCentricPages;

import BusinessLogicLayer.TransactionAction.ITransactionModel;
import PresentationLayer.Pages.IAbstractPage;

import java.util.ArrayList;

public interface ICustomerCentricPagesFactory {
    IAbstractPage createBankStatementTable(ArrayList<ITransactionModel> transactionList);
}
