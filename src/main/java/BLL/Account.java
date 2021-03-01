package BLL;

import DAL.ExecuteDatabase;
import DAL.FetchAccountDetails;

import java.sql.ResultSet;

public class Account {
    private String accountNumber;
    public Account(String accountNumber){
        this.accountNumber = accountNumber;
    }

    private void getAccountDetails (){
        FetchAccountDetails fetchAccountDetails = new FetchAccountDetails();
        ExecuteDatabase executeDatabase = new ExecuteDatabase();
        ResultSet resultSet = executeDatabase.executeSelect(fetchAccountDetails);
        
    }

}
