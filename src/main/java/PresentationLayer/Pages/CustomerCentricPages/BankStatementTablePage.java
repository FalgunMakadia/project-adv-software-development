package PresentationLayer.Pages.CustomerCentricPages;

import BusinessLogicLayer.TransactionAction.TransactionModel;
import PresentationLayer.Pages.Page;

import java.util.ArrayList;

public class BankStatementTablePage extends Page {
    private ArrayList<TransactionModel> transactionList;

    public BankStatementTablePage(ArrayList<TransactionModel> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public void printPage() {
        System.out.println("===================================");
        System.out.printf("%10s %10s %10s", "Type", "Amount", "Date");
        System.out.println();
        System.out.println("===================================");
        for(TransactionModel transaction: transactionList) {
            System.out.format("%10s %10s %10s",
                    transaction.getTransactionType(),
                    transaction.getAmount(),
                    transaction.getDate());
            System.out.println();
        }
    }
}
