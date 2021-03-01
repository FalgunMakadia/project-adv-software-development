package Data;

import BLL.BankAction.*;
import BLL.CommonAction.Signout;
import BLL.CommonAction.Action;
import PL.BankPage;
import PL.ExistingBankAccountPage;

import java.util.*;

public enum BankManagerMenu {

    OPEN_NEW_BANK_ACCOUNT(1,"Open New Bank Account", new OpenNewAccount(), null),
    OPEN_EXISTING_BANK_ACCOUNT(2,"Open Existing Bank Account", null, new ExistingBankAccountPage()),
    WORKLIST(3,"Worklist", new Worklist(), null),
    ENROLL_NEW_EMPLOYEE(4,"Enroll New Employee", new EnrollNewEmployee(), null),
    SIGN_OUT(5,"Sign out", new Signout(), null);

    private int sequenceNumber;
    private String description;
    private Action bankActions;
    private BankPage subMenu;

    BankManagerMenu(int number, String desc, Action action,BankPage subMenu){
        this.sequenceNumber = number;
        this.description = desc;
        this.bankActions = action;
        this.subMenu = subMenu;
    }


    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Action getAction() {
        return bankActions;
    }

    public BankPage getSubMenu() {
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
