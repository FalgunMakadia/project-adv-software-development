package DataAccessLayer;

import BusinessLogicLayer.TransactionAction.TransactionModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAccountDatabase {
    int getUserBalance(String accountNumber);

    int updateBalance(int finalBalance, String accountNumber);

    boolean verifyAccountNumber(String accountNumber);

    void saveTransaction(ArrayList<TransactionModel> transactionList);

    ArrayList<TransactionModel> getMiniStatement(String accountNumber);
}
