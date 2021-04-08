package BusinessLogicLayer.CustomerCentricAction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanEstimatorActionTest {

    @Test
    public void calculateEmiTest() {
        LoanEstimatorAction loanEstimatorAction = new LoanEstimatorAction();

        assertEquals(45.22729145618458, loanEstimatorAction.calculateEmi(1000, 2));
    }

    @Test
    public void calculateEmiFirstBracketTest() {
        LoanEstimatorAction loanEstimatorAction = new LoanEstimatorAction();

        assertEquals(452.2729145618458, loanEstimatorAction.calculateEmi(10000, 2));
    }

    @Test
    public void calculateEmiSecondBracketTest() {
        LoanEstimatorAction loanEstimatorAction = new LoanEstimatorAction();

        assertEquals(1130.6822864046146, loanEstimatorAction.calculateEmi(25000, 2));
    }

    @Test
    public void calculateEmiThirdBracketTest() {
        LoanEstimatorAction loanEstimatorAction = new LoanEstimatorAction();

        assertEquals(2487.501030090152, loanEstimatorAction.calculateEmi(55000, 2));
    }

    @Test
    public void calculateEmiFourthBracketTest() {
        LoanEstimatorAction loanEstimatorAction = new LoanEstimatorAction();

        assertEquals(9045.458291236917, loanEstimatorAction.calculateEmi(200000, 2));
    }
}
