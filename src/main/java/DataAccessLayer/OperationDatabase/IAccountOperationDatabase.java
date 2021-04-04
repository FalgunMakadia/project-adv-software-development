package DataAccessLayer.OperationDatabase;

import BusinessLogicLayer.TransactionAction.TransactionModel;

import java.util.ArrayList;

public interface IAccountOperationDatabase {
    int getBalance(String accountNumber);

    int updateBalance(int finalBalance, String accountNumber);

    boolean verifyAccountNumber(String accountNumber);

    void saveTransaction(ArrayList<TransactionModel> transactionList);

    ArrayList<TransactionModel> getMiniStatement(String accountNumber);
}
