package PresentationLayer.Pages.CustomerCentricPages;

import BusinessLogicLayer.TransactionAction.TransactionModel;
import PresentationLayer.Pages.IPage;

import java.util.ArrayList;

public interface ICustomerCentricPagesFactory {
    IPage createBankStatementTable(ArrayList<TransactionModel> transactionList);
}
