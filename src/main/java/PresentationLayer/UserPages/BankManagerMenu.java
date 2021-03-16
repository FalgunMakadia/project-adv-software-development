package PresentationLayer.UserPages;

import BusinessLogicLayer.BankEmployee.*;
import BusinessLogicLayer.BankManager.*;
import BusinessLogicLayer.CommonAction.Action;
import PresentationLayer.BankActionPages.EnrollNewEmployeePage;
import PresentationLayer.BankActionPages.ExistingBankAccountPage;
import PresentationLayer.BankActionPages.OpenNewAccountPage;
import PresentationLayer.BankActionPages.WorklistPage;
import PresentationLayer.Page;

import java.util.*;

public enum BankManagerMenu {

    OPEN_NEW_BANK_ACCOUNT(1, "Open New Bank Account",  new OpenNewAccountPage()),
    OPEN_EXISTING_BANK_ACCOUNT(2, "Open Existing Bank Account", new ExistingBankAccountPage()),
    WORKLIST(3, "Worklist", new WorklistPage()),
    ENROLL_NEW_EMPLOYEE(4,"Enroll New Employee", new EnrollNewEmployeePage()),
    SIGN_OUT(5,"Sign out", new SignOut());



    private int sequenceNumber;
    private String description;
    private Page menuPage;

    BankManagerMenu(int number, String desc, Page menuPage){
        this.sequenceNumber = number;
        this.description = desc;
        this.menuPage = menuPage;
    }


    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Page getMenuPage() {
        return menuPage;
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
