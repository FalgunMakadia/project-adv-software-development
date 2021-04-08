package BusinessLogicLayer.UserAction;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import BusinessLogicLayer.User.BankEmployeeProfile;

public class BankEmployeeProfileTest {
    String actual;
    String expected;

    @Test
    public void getProfileRoleTest()
    {
        BankEmployeeProfile bankEmployeeProfile=new BankEmployeeProfile();
        actual=bankEmployeeProfile.getProfileRole();
        expected="E";
        assertEquals(expected, actual);


    }

    public void getProfileRoleFailTest()
    {
        BankEmployeeProfile bankEmployeeProfile=new BankEmployeeProfile();
        actual=bankEmployeeProfile.getProfileRole();
        expected="C";
        assertNotEquals(expected, actual);


    }
    
}
