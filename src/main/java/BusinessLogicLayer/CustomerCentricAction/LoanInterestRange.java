package BusinessLogicLayer.CustomerCentricAction;

public class LoanInterestRange {
    private double start;
    private double end;
    private double approvedLoanAmount;
    private double approvedLoanInterest;
    private boolean approvedLoanStatus = false;

    public LoanInterestRange(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public LoanInterestRange(double start, double end, double approvedLoan) {
        this.start = start;
        this.end = end;
        this.approvedLoanAmount = approvedLoan;
    }

    public double getApprovedLoanAmount() {
        return approvedLoanAmount;
    }

    public boolean includes(int argument) {
        return argument >= start && argument < end;
    }

    public void setApprovedLoanStatus(boolean status) {
        approvedLoanStatus = status;
    }

    public boolean getApprovedLoanStatus() {
        return approvedLoanStatus;
    }

    public void setApprovedLoanInterest(double interestRate) {
        approvedLoanInterest = interestRate;
    }

    public double getApprovedLoanInterest() {
        return approvedLoanInterest;
    }

}
