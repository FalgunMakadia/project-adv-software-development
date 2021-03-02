package PL.Customer;

import java.util.HashMap;
import java.util.Map;
import BLL.CommonAction.Action;
import BLL.Transaction.*;
import BLL.CustomerAction.*;

public enum CustomerCentricMenu {

    UPDATE_PERSONAL_DETAILS(1, "Update Personal Details", "A", new UpdatePersonalDetails()),
    WITHDRAW(2, "Withdraw", "A", new Withdraw()),
    DEPOSIT(3, "Deposit", "A", new Deposit()),
    TRANSFER(4, "Transfer", "A", new Transfer()),
    BANK_STATEMENT(5, "Bank Statement", "A", new BankStatement()),
    CHECK_BALANCE(6, "Check Balance", "A", new CheckBalance()),
    UPDATE_PASSWORD(7, "Update Password", "A", new UpdatePassword()),
    LOAN_ESTIMATOR(8, "Loan Estimator", "A", new UpdatePassword()),
    SIGN_OUT(9, "Sign out", "A", null);

    public int sequenceNumber;
    public String description;
    private String actionFlag;
    public Action customerActions;

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public Action getCustomerActions() {
        return customerActions;
    }

    public String getActionFlag() {
        return actionFlag;
    }


    CustomerCentricMenu(int number,String desc, String actionFlag, Action action){
        this.sequenceNumber = number;
        this.description = desc;
        this.actionFlag = actionFlag;
        this.customerActions = action;
    }


    public static Map<Integer,CustomerCentricMenu> getActionFromSequence = new HashMap();

    static {
        for(CustomerCentricMenu customerCentricMenu : CustomerCentricMenu.values()) {
            getActionFromSequence.put(customerCentricMenu.getSequenceNumber(),customerCentricMenu);
        }
    }

}
