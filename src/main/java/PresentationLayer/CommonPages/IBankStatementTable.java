package PresentationLayer.CommonPages;

import BusinessLogicLayer.TransactionAction.TransactionModel;

import java.util.ArrayList;

public interface IBankStatementTable {
    void printBankStatementTable(ArrayList<TransactionModel> transactionList);
}
