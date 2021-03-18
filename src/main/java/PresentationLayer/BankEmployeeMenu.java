package PresentationLayer;


import BusinessLogicLayer.BankEmployee.ExistingBankAccount;
import BusinessLogicLayer.BankEmployee.OpenNewAccount;
import BusinessLogicLayer.BankEmployee.WorkList;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.SignOut;

import java.util.HashMap;
import java.util.Map;

public enum BankEmployeeMenu {

    OPEN_NEW_BANK_ACCOUNT(1, "Open New Bank Account", new OpenNewAccount()),
    OPEN_EXISTING_BANK_ACCOUNT(2, "Open Existing Bank Account", new ExistingBankAccount()),
    WORKLIST(3, "WorkList", new WorkList()),
    SIGN_OUT(4, "Sign out", new SignOut());



    private int sequenceNumber;
    private String description;
    private Action action;


    BankEmployeeMenu(int number, String desc, Action action) {
        this.sequenceNumber = number;
        this.description = desc;
        this.action = action;

    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Action getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }

    public static Map<Integer, BankEmployeeMenu> getActionFromSequence = new HashMap();

    static {
        for (BankEmployeeMenu bankEmployeeMenu : BankEmployeeMenu.values()) {
            getActionFromSequence.put(bankEmployeeMenu.getSequenceNumber(), bankEmployeeMenu);
        }
    }
}
