package data;

import BLL.CustomerAction.*;
import BLL.CommonAction.*;

import java.util.HashMap;
import java.util.Map;

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
    public CustomerActions customerActions;
    public CommonActions commonActions;

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public CustomerActions getCustomerActions() {
        return customerActions;
    }

    public CommonActions getCommonActions() {
        return commonActions;
    }

    CustomerCentricMenu(int number,String desc, CustomerActions a){
        this.sequenceNumber = number;
        this.description = desc;
        this.customerActions = a;
    }

    CustomerCentricMenu(int number,String desc, CommonActions a){
        this.sequenceNumber = number;
        this.description = desc;
        this.commonActions = a;
    }

    public static Map<Integer,CustomerCentricMenu> getActionFromSequence = new HashMap();

    static {
        for(CustomerCentricMenu customerCentricMenu : CustomerCentricMenu.values()) {
            getActionFromSequence.put(customerCentricMenu.getSequenceNumber(),customerCentricMenu);
        }
    }

}
