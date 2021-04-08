package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.AbstractAction;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

import java.util.HashMap;
import java.util.Map;

public class CheckPreApprovedLoanAction extends AbstractAction {
    private static final String ACTION_TITLE = "Check Pre-Approved Loan";
    private static final int LOAN_BRACKET_ONE_LOWER_LIMIT = 10000;
    private static final int LOAN_BRACKET_TWO_LOWER_LIMIT = 25000;
    private static final int LOAN_BRACKET_THREE_LOWER_LIMIT = 50000;
    private static final int LOAN_BRACKET_FOUR_LOWER_LIMIT = 100000;
    private static final int LOAN_BRACKET_ONE_APPROVED_AMOUNT = 15000;
    private static final int LOAN_BRACKET_TWO_APPROVED_AMOUNT = 30000;
    private static final int LOAN_BRACKET_THREE_APPROVED_AMOUNT = 75000;
    private static final int LOAN_BRACKET_FOUR_APPROVED_AMOUNT = 100000;
    private static final double LOAN_BRACKET_ONE_INTEREST_RATE = 8.0;
    private static final double LOAN_BRACKET_TWO_INTEREST_RATE = 8.2;
    private static final double LOAN_BRACKET_THREE_INTEREST_RATE = 8.5;
    private static final double DEFAULT_INTEREST_RATE = 8.8;

    private int balance = 0;
    private Map<Double, LoanInterestRange> loanInterestRangeMap;
    private IAccountOperationDatabase accountOperationDatabase;

    public CheckPreApprovedLoanAction() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();

        loanInterestRangeMap = new HashMap<>();
        loanInterestRangeMap.put(LOAN_BRACKET_ONE_INTEREST_RATE, new LoanInterestRange(LOAN_BRACKET_ONE_LOWER_LIMIT, LOAN_BRACKET_TWO_LOWER_LIMIT, LOAN_BRACKET_ONE_APPROVED_AMOUNT));
        loanInterestRangeMap.put(LOAN_BRACKET_TWO_INTEREST_RATE, new LoanInterestRange(LOAN_BRACKET_TWO_LOWER_LIMIT, LOAN_BRACKET_THREE_LOWER_LIMIT, LOAN_BRACKET_TWO_APPROVED_AMOUNT));
        loanInterestRangeMap.put(LOAN_BRACKET_THREE_INTEREST_RATE, new LoanInterestRange(LOAN_BRACKET_THREE_LOWER_LIMIT, LOAN_BRACKET_FOUR_LOWER_LIMIT, LOAN_BRACKET_THREE_APPROVED_AMOUNT));
        loanInterestRangeMap.put(DEFAULT_INTEREST_RATE, new LoanInterestRange(LOAN_BRACKET_FOUR_LOWER_LIMIT, Double.POSITIVE_INFINITY, LOAN_BRACKET_FOUR_APPROVED_AMOUNT));
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        String accountNumber = loggedInUserContext.getAccountNumber();

        balance = accountOperationDatabase.getBalance(accountNumber);

        double annualInterest = getPreApprovedLoanAnnualInterest(balance);
        double preApprovedLoanAmount = getPreApprovedLoanAmount(balance);

        if (preApprovedLoanAmount == 0) {
            userInterface.displayMessage("You are not eligible for Pre-Approved loan(Minimum 10000 CAD is required)");
        } else {
            userInterface.displayMessage("You have a pre-approved loan of " + preApprovedLoanAmount + "CAD with " + annualInterest + "% annual interest.");
        }
        userInterface.insertEmptyLine();
    }

    @Override
    protected void setCurrentPageInContext() {
        loggedInUserContext.setCurrentPage(ACTION_TITLE);
    }

    @Override
    public String getActionTitle() {
        return ACTION_TITLE;
    }

    public double getPreApprovedLoanAnnualInterest(int balance) {
        double annualInterest = DEFAULT_INTEREST_RATE;
        LoanInterestRange loanInterestRange = getPreApprovedLoanBracket(balance);
        if (loanInterestRange.getApprovedLoanStatus()) {
            annualInterest = loanInterestRange.getApprovedLoanInterest();
        }
        return annualInterest;
    }

    public double getPreApprovedLoanAmount(int balance) {
        double PreApprovedLoanAmount = 0;
        LoanInterestRange loanInterestRange = getPreApprovedLoanBracket(balance);
        if (loanInterestRange.getApprovedLoanStatus()) {
            PreApprovedLoanAmount = loanInterestRange.getApprovedLoanAmount();
        }
        return PreApprovedLoanAmount;
    }

    private LoanInterestRange getPreApprovedLoanBracket(int balance) {
        LoanInterestRange loanInterestRange = null;
        for (Map.Entry<Double, LoanInterestRange> loanInterestRangeEntry : loanInterestRangeMap.entrySet()) {
            loanInterestRange = loanInterestRangeEntry.getValue();
            if (loanInterestRange.includes(balance)) {
                loanInterestRange.setApprovedLoanInterest(loanInterestRangeEntry.getKey());
                loanInterestRange.setApprovedLoanStatus(true);
                break;
            }
        }
        return loanInterestRange;
    }
}
