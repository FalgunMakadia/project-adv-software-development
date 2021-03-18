package PresentationLayer;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.*;
import BusinessLogicLayer.SignOut;
import BusinessLogicLayer.Transaction.Deposit;
import BusinessLogicLayer.Transaction.Transfer;
import BusinessLogicLayer.Transaction.Withdraw;

import java.util.HashMap;
import java.util.Map;



public enum CustomerMenu {

    UPDATE_PERSONAL_DETAILS(1, "Update Personal Details", new UpdatePersonalDetails()),
    WITHDRAW(2, "Withdraw", new Withdraw()),
    DEPOSIT(3, "Deposit", new Deposit()),
    TRANSFER(4, "Transfer", new Transfer()),
    BANK_STATEMENT(5, "Bank Statement", new BankStatement()),
    CHECK_BALANCE(6, "Check Balance", new CheckBalance()),
    UPDATE_PASSWORD(7, "Update Password", new UpdatePassword()),
    LOAN_ESTIMATOR(8, "Loan Estimator", new LoanEstimator()),
    SIGN_OUT(9, "Sign out", new SignOut());

    private int sequenceNumber;
    private String description;
    private Action action;

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public Action getCustomerActions() {
        return action;
    }




    CustomerMenu(int number, String desc,  Action action){
        this.sequenceNumber = number;
        this.description = desc;
        this.action = action;
    }


    public static Map<Integer, CustomerMenu> getActionFromSequence = new HashMap();

    static {
        for(CustomerMenu customerCentricMenu : CustomerMenu.values()) {
            getActionFromSequence.put(customerCentricMenu.getSequenceNumber(),customerCentricMenu);
        }
    }

}
