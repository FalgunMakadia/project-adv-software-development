package PresentationLayer.UserPages;


import PresentationLayer.BankActionPages.ExistingBankAccountPage;
import PresentationLayer.BankActionPages.OpenNewAccountPage;
import PresentationLayer.Page;
import PresentationLayer.BankActionPages.WorklistPage;

import java.util.HashMap;
import java.util.Map;

public enum BankEmployeeMenu {

    OPEN_NEW_BANK_ACCOUNT(1, "Open New Bank Account", "A", new OpenNewAccountPage()),
    OPEN_EXISTING_BANK_ACCOUNT(2, "Open Existing Bank Account", "M", new ExistingBankAccountPage()),
    WORKLIST(3, "Worklist", "A", new WorklistPage()),
    SIGN_OUT(4, "Sign out", "", null);


    private int sequenceNumber;
    private String description;
    private Page Page;


    BankEmployeeMenu(int number, String desc, String actionFlag, Page Page) {
        this.sequenceNumber = number;
        this.description = desc;
        this.Page = Page;

    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Page getAction() {
        return Page;
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
