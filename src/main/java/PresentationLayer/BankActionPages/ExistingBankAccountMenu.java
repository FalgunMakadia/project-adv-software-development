package PresentationLayer.BankActionPages;

import BLL.CommonAction.*;
import BLL.Transaction.*;
import java.util.HashMap;
import java.util.Map;

public enum ExistingBankAccountMenu  {
    WITHDRAW(1,"Withdraw", "A", new Withdraw()),
    DEPOSIT(2,"Deposit", "A", new Deposit()),
    TRANSFER(3,"Transfer", "A", new Transfer()),
    SIGN_OUT(4,"Sign out", "A", null);


    public int sequenceNumber;
    public String description;
    private String actionFlag;
    public Action bankActions;

    ExistingBankAccountMenu(int number, String desc, String actionFlag, Action action){
        this.sequenceNumber = number;
        this.description = desc;
        this.actionFlag = actionFlag;
        this.bankActions = action;
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

    public String getDescription() {
        return description;
    }

    public static Map<Integer, ExistingBankAccountMenu> getActionFromSequence = new HashMap();

    static {
        for(ExistingBankAccountMenu existingBankAccountMenu : ExistingBankAccountMenu.values()) {
            getActionFromSequence.put(existingBankAccountMenu.getSequenceNumber(),existingBankAccountMenu);
        }
    }

}
