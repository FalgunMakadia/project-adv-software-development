package Data;

import BLL.CommonAction.Action;
import BLL.CommonAction.*;

import java.util.HashMap;
import java.util.Map;

public enum ExistingBankAccountMenu  {
    WITHDRAW(1,"Withdraw", new Withdraw()),
    DEPOSIT(2,"Deposit", new Deposit()),
    TRANSFER(3,"Transfer", new Transfer()),
    SIGN_OUT(4,"Sign out", new Signout());


    public int sequenceNumber;
    public String description;
    public Action bankActions;

    ExistingBankAccountMenu(int number, String desc, Action action){
        this.sequenceNumber = number;
        this.description = desc;
        this.bankActions = action;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Action getAction() {
        return bankActions;
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
