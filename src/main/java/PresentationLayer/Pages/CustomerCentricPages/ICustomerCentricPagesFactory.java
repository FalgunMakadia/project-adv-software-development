package PresentationLayer.Pages.CustomerCentricPages;

import BusinessLogicLayer.TransactionAction.ITransactionModel;
import PresentationLayer.Pages.IPage;

import java.util.ArrayList;

public interface ICustomerCentricPagesFactory {
    IPage createBankStatementTable(ArrayList<ITransactionModel> transactionList);
}
