package BLL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void validUserTest() {

        Login login1 = new Login("admin", "admin", "E");
        Login login2 = new Login("abc", "abc", "E");
        Login login3 = new Login("abc", "abc", "C");
        Login login4 = new Login("abc", "xyz", "C");
        Login login5 = new Login("admin", "admin", "C");
        Login login6 = new Login("", "admin", "C");
        Login login7 = new Login("admin", "", "C");
        Login login8 = new Login("", "", "C");
        Login login9 = new Login("", "admin", "E");
        Login login10 = new Login("admin", "", "E");
        Login login11 = new Login("", "", "E");

        assertEquals("E", login1.validUser());

        assertEquals("", login2.validUser());

        assertEquals("C", login3.validUser());

        assertEquals("", login4.validUser());

        assertEquals("", login5.validUser());

        assertEquals("", login6.validUser());

        assertEquals("", login7.validUser());

        assertEquals("", login8.validUser());

        assertEquals("", login9.validUser());

        assertEquals("", login10.validUser());

        assertEquals("", login11.validUser());

    }


}