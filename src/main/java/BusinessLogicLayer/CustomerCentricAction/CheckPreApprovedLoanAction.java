package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.Action;
import DataAccessLayer.OperationDatabase.IAccountOperationDatabase;
import DataAccessLayer.OperationDatabase.IOperationDatabaseFactory;

import java.util.HashMap;
import java.util.Map;

public class CheckPreApprovedLoanAction extends Action {
    private static final String ACTION_TITLE = "Check Pre-Approved Loan";
    private static final double DEFAULT_INTEREST_RATE = 8.8;

    private int balance = 0;
    private Map<Double, LoanInterestRange> loanInterestRangeMap;
    private IAccountOperationDatabase accountOperationDatabase;

    public CheckPreApprovedLoanAction() {
        IOperationDatabaseFactory operationDatabaseFactory = databaseFactory.createOperationDatabaseFactory();
        accountOperationDatabase = operationDatabaseFactory.createAccountOperationDatabase();

        loanInterestRangeMap = new HashMap<>();
        loanInterestRangeMap.put(8.0, new LoanInterestRange(10000, 25000, 15000));
        loanInterestRangeMap.put(8.2, new LoanInterestRange(25000, 50000, 30000));
        loanInterestRangeMap.put(8.5, new LoanInterestRange(50000, 100000, 75000));
        loanInterestRangeMap.put(8.8, new LoanInterestRange(100000, Double.POSITIVE_INFINITY, 100000));
    }

    @Override
    public void performAction() {
        setCurrentPageInContext();
        String accountNumber = loggedInUserContext.getAccountNumber();

        balance = accountOperationDatabase.getBalance(accountNumber);

        double annualInterest = getPreApprovedLoanAnnualInterest(balance);
        double preApprovedLoanAmount = getPreApprovedLoanAmount(balance);

        userInterface.displayMessage("You have a pre-approved loan of " + preApprovedLoanAmount + "CAD with " + annualInterest + "% annual interest.");
        userInterface.addDelay();
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
