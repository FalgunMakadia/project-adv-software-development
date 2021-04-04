package BusinessLogicLayer.CustomerCentricAction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckPreApprovedLoanActionTest {
    @Test
    public void getPreApprovedLoanAmountTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAmount(100);
        assertEquals(0, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountFirstBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAmount(10000);
        assertEquals(15000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountSecondBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAmount(25000);
        assertEquals(30000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountThirdBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAmount(50000);
        assertEquals(75000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanAmountFourthBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAmount(100000);
        assertEquals(100000, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAnnualInterest(100);
        assertEquals(8.8, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestFirstBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAnnualInterest(10000);
        assertEquals(8, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestSecondBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAnnualInterest(25000);
        assertEquals(8.2, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestThirdBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAnnualInterest(50000);
        assertEquals(8.5, approvedLoanAmount);
    }

    @Test
    public void getPreApprovedLoanInterestFourthBracketTest() {
        CheckPreApprovedLoanAction checkPreApprovedLoanAction = new CheckPreApprovedLoanAction();
        double approvedLoanAmount = checkPreApprovedLoanAction.getPreApprovedLoanAnnualInterest(100000);
        assertEquals(8.8, approvedLoanAmount);
    }

}
