package BLL;

import BLL.CommonAction.Login;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void validUserTest() {

        Login login1 = new Login("admin", "admin");
        assertEquals("E", login1.validUser());

        Login login2 = new Login("abc", "abc");
        assertEquals("", login2.validUser());

        Login login3 = new Login("abc", "abc");
        assertEquals("C", login3.validUser());

        Login login4 = new Login("abc", "xyz");
        assertEquals("", login4.validUser());

        Login login5 = new Login("admin", "admin");
        assertEquals("", login5.validUser());

        Login login6 = new Login("", "admin");
        assertEquals("", login6.validUser());

        Login login7 = new Login("admin", "");
        assertEquals("", login7.validUser());

        Login login8 = new Login("", "");
        assertEquals("", login8.validUser());

        Login login9 = new Login("", "admin");
        assertEquals("", login9.validUser());

        Login login10 = new Login("admin", "");
        assertEquals("", login10.validUser());

        Login login11 = new Login("", "");
        assertEquals("", login11.validUser());

    }
}