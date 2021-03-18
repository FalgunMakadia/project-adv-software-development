package PresentationLayer;



import BusinessLogicLayer.BankEmployee.ExistingBankAccount;
import BusinessLogicLayer.BankEmployee.OpenNewAccount;
import BusinessLogicLayer.BankEmployee.WorkList;
import BusinessLogicLayer.BankManager.EnrollNewEmployee;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.SignOut;

import java.util.*;

public enum BankManagerMenu {

    OPEN_NEW_BANK_ACCOUNT(1, "Open New Bank Account",  new OpenNewAccount()),
    OPEN_EXISTING_BANK_ACCOUNT(2, "Open Existing Bank Account", new ExistingBankAccount()),
    WORKLIST(3, "WorkList", new WorkList()),
    ENROLL_NEW_EMPLOYEE(4,"Enroll New Employee", new EnrollNewEmployee()),
    SIGN_OUT(5,"Sign out", new SignOut());



    private int sequenceNumber;
    private String description;
    private Action action;

    BankManagerMenu(int number, String desc, Action action){
        this.sequenceNumber = number;
        this.description = desc;
        this.action = action;
    }


    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Action getMenuPage() {
        return action;
    }

    public String getDescription() {
        return description;
    }


    public static Map<Integer, BankManagerMenu> getActionFromSequence = new HashMap();

    static {
        for(BankManagerMenu bankCentricMenu : BankManagerMenu.values()) {
            getActionFromSequence.put(bankCentricMenu.getSequenceNumber(),bankCentricMenu);
        }
    }

}
