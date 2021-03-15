package PresentationLayer.UserPages;

import java.util.HashMap;
import java.util.Map;

import PresentationLayer.CustomerActionPages.BankStatementPage;
import PresentationLayer.CustomerActionPages.CheckBalancePage;
import PresentationLayer.CustomerActionPages.UpdatePasswordPage;
import PresentationLayer.CustomerActionPages.UpdatePersonalDetailsPage;
import PresentationLayer.CommonActionPages.DepositPage;
import PresentationLayer.Page;
import PresentationLayer.CommonActionPages.TransferPage;
import PresentationLayer.CommonActionPages.WithdrawPage;

public enum CustomerMenu {

    UPDATE_PERSONAL_DETAILS(1, "Update Personal Details", "A", new UpdatePersonalDetailsPage()),
    WITHDRAW(2, "Withdraw", "A", new WithdrawPage()),
    DEPOSIT(3, "Deposit", "A", new DepositPage()),
    TRANSFER(4, "Transfer", "A", new TransferPage()),
    BANK_STATEMENT(5, "Bank Statement", "A", new BankStatementPage()),
    CHECK_BALANCE(6, "Check Balance", "A", new CheckBalancePage()),
    UPDATE_PASSWORD(7, "Update Password", "A", new UpdatePasswordPage()),
    LOAN_ESTIMATOR(8, "Loan Estimator", "A", new UpdatePasswordPage()),
    SIGN_OUT(9, "Sign out", "A", null);

    public int sequenceNumber;
    public String description;
    private String actionFlag;
    public Page customerPage;

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public Page getCustomerActions() {
        return customerPage;
    }

    public String getActionFlag() {
        return actionFlag;
    }


    CustomerMenu(int number, String desc, String actionFlag, Page page){
        this.sequenceNumber = number;
        this.description = desc;
        this.actionFlag = actionFlag;
        this.customerPage = page;
    }


    public static Map<Integer, CustomerMenu> getActionFromSequence = new HashMap();

    static {
        for(CustomerMenu customerCentricMenu : CustomerMenu.values()) {
            getActionFromSequence.put(customerCentricMenu.getSequenceNumber(),customerCentricMenu);
        }
    }

}
