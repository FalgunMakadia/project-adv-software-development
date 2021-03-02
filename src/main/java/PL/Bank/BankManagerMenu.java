package PL.Bank;

import BLL.BankEmployee.*;
import BLL.BankManager.*;
import BLL.CommonAction.Action;
import PL.Page;

import java.util.*;

public enum BankManagerMenu {

    OPEN_NEW_BANK_ACCOUNT(1,"Open New Bank Account", "A", new OpenNewAccount(), null),
    OPEN_EXISTING_BANK_ACCOUNT(2,"Open Existing Bank Account", "M", null, new ExistingBankAccountPage()),
    WORKLIST(3,"Worklist", "A", new Worklist(), null),
    ENROLL_NEW_EMPLOYEE(4,"Enroll New Employee", "M", new EnrollNewEmployee(), null),
    SIGN_OUT(5,"Sign out", "", null, null);

    private int sequenceNumber;
    private String description;
    private String actionFlag;
    private Action bankActions;
    private Page subMenu;

    BankManagerMenu(int number, String desc, String actionFlag, Action action, Page subMenu){
        this.sequenceNumber = number;
        this.description = desc;
        this.actionFlag = actionFlag;
        this.bankActions = action;
        this.subMenu = subMenu;
    }


    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Action getAction() {
        return bankActions;
    }

    public String getActionFlag() {
        return actionFlag;
    }

    public Page getSubMenu() {
        return subMenu;
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
