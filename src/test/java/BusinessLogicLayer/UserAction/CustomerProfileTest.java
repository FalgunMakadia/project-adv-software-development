package BusinessLogicLayer.UserAction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import BusinessLogicLayer.User.CustomerProfile;

public class CustomerProfileTest {
    String actual;
    String expected;

    @Test
    public void getProfileRoleTest()
    {
        CustomerProfile customerProfile=new CustomerProfile();
        actual=customerProfile.getProfileRole();
        expected="C";
        assertEquals(expected, actual);


    }

    @Test
    public void getProfileRoleFailTest()
    {
        CustomerProfile customerProfile=new CustomerProfile();
        actual=customerProfile.getProfileRole();
        expected="E";
        assertNotEquals(expected, actual);



    }
}
