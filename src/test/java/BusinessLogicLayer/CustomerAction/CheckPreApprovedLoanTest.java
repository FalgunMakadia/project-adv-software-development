package BusinessLogicLayer.CustomerAction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckPreApprovedLoanTest {
    @Test
    public void getPreApprovedLoanAmountTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAmount(100);
        assertEquals(0, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountFirstBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAmount(10000);
        assertEquals(15000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountSecondBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAmount(25000);
        assertEquals(30000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountThirdBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAmount(50000);
        assertEquals(75000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountFourthBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAmount(100000);
        assertEquals(100000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAnnualInterest(100);
        assertEquals(8.8, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestFirstBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAnnualInterest(10000);
        assertEquals(8, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestSecondBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAnnualInterest(25000);
        assertEquals(8.2, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestThirdBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAnnualInterest(50000);
        assertEquals(8.5, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestFourthBracketTest() {
        CheckPreApprovedLoan checkPreApprovedLoan = new CheckPreApprovedLoan();
        double approvedLoanAmount = checkPreApprovedLoan.getPreApprovedLoanAnnualInterest(100000);
        assertEquals(8.8, approvedLoanAmount);
    }

}
