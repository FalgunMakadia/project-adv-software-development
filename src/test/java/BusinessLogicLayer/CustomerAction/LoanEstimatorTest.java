package BusinessLogicLayer.CustomerAction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanEstimatorTest {
    @Test
    public void calculateEmiTest(){
        LoanEstimator loanEstimator = new LoanEstimator();

        assertEquals(45.22729145618458  ,loanEstimator.calculateEmi(1000,2));
    }
    @Test
    public void calculateEmiFirstBracketTest(){
        LoanEstimator loanEstimator = new LoanEstimator();

        assertEquals(452.2729145618458  ,loanEstimator.calculateEmi(10000,2));
    }
    @Test
    public void calculateEmiSecondBracketTest(){
        LoanEstimator loanEstimator = new LoanEstimator();

        assertEquals(1130.6822864046146  ,loanEstimator.calculateEmi(25000,2));
    }
    @Test
    public void calculateEmiThirdBracketTest(){
        LoanEstimator loanEstimator = new LoanEstimator();

        assertEquals(2487.501030090152  ,loanEstimator.calculateEmi(55000,2));
    }
    @Test
    public void calculateEmiFourthBracketTest(){
        LoanEstimator loanEstimator = new LoanEstimator();

        assertEquals(9045.458291236917  ,loanEstimator.calculateEmi(200000,2));
    }
}
