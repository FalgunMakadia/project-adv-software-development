package data;

import BLL.BankAction.*;

import java.util.*;

public enum BankCentricMenu {

    OPEN_NEW_BANK_ACCOUNT(1,"Open New Bank Account", new OpenNewAccount()),
    OPEN_EXISTING_BANK_ACCOUNT(2,"Open Existing Bank Account", new ExistingAccountAction()),
    WORKLIST(3,"Worklist", new Worklist()),
    ENROLL_NEW_EMPLOYEE(4,"Enroll New Employee", new EnrollNewEmployee()),
    SIGN_OUT(5,"Sign out", new Signout());


    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public BankActions getAction() {
        return bankActions;
    }

    public String getDescription() {
        return description;
    }

    public int sequenceNumber;
    public String description;
    public BankActions bankActions;

    BankCentricMenu(int number,String desc, BankActions a){
        this.sequenceNumber = number;
        this.description = desc;
        this.bankActions = a;
    }

    public static Map<Integer,BankCentricMenu> getActionFromSequence = new HashMap();

    static {
        for(BankCentricMenu bankCentricMenu : BankCentricMenu.values()) {
            getActionFromSequence.put(bankCentricMenu.getSequenceNumber(),bankCentricMenu);
        }
    }
}
