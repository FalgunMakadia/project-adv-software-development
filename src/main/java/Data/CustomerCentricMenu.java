package Data;

import BLL.CustomerAction.*;
import BLL.CommonAction.*;

import java.util.HashMap;
import java.util.Map;
import BLL.CommonAction.Action;

public enum CustomerCentricMenu {

    UPDATE_PERSONAL_DETAILS(1, "Update Personal Details", new UpdatePersonalDetails()),
    WITHDRAW(2, "Withdraw", new Withdraw()),
    DEPOSIT(3, "Deposit", new Deposit()),
    TRANSFER(4, "Transfer", new Transfer()),
    BANK_STATEMENT(5, "Bank Statement", new BankStatement()),
    CHECK_BALANCE(6, "Check Balance", new CheckBalance()),
    UPDATE_PASSWORD(7, "Update Password", new UpdatePassword());

    public int sequenceNumber;
    public String description;
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

    CustomerCentricMenu(int number,String desc, Action action){
        this.sequenceNumber = number;
        this.description = desc;
        this.customerActions = action;
    }


    public static Map<Integer,CustomerCentricMenu> getActionFromSequence = new HashMap();

    static {
        for(CustomerCentricMenu customerCentricMenu : CustomerCentricMenu.values()) {
            getActionFromSequence.put(customerCentricMenu.getSequenceNumber(),customerCentricMenu);
        }
    }

}
