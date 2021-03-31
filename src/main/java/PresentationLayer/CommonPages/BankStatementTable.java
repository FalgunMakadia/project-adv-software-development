package PresentationLayer.CommonPages;

import BusinessLogicLayer.TransactionAction.TransactionModel;

import java.util.ArrayList;

public class BankStatementTable implements IBankStatementTable {
    @Override
    public void printBankStatementTable(ArrayList<TransactionModel> transactionList) {
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
