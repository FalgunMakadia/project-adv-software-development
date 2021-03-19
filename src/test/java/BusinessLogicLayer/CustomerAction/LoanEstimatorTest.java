package BusinessLogicLayer.CustomerAction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanEstimatorTest {
    @Test
    public void calculateEmiTest(){
        LoanEstimator loanEstimator = new LoanEstimator();

        assertEquals(10179.160528647808  ,loanEstimator.calculateEmi(200000,2));
    }
}
