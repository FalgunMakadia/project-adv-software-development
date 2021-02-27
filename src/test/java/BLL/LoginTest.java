package BLL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void validUserTest() {

        Login login1 = new Login("admin", "admin", "E");
        assertEquals("E", login1.validUser());

        Login login2 = new Login("abc", "abc", "E");
        assertEquals("", login2.validUser());

        Login login3 = new Login("abc", "abc", "C");
        assertEquals("C", login3.validUser());

        Login login4 = new Login("abc", "xyz", "C");
        assertEquals("", login4.validUser());

        Login login5 = new Login("admin", "admin", "C");
        assertEquals("", login5.validUser());

        Login login6 = new Login("", "admin", "C");
        assertEquals("", login6.validUser());

        Login login7 = new Login("admin", "", "C");
        assertEquals("", login7.validUser());

        Login login8 = new Login("", "", "C");
        assertEquals("", login8.validUser());

        Login login9 = new Login("", "admin", "E");
        assertEquals("", login9.validUser());

        Login login10 = new Login("admin", "", "E");
        assertEquals("", login10.validUser());

        Login login11 = new Login("", "", "E");
        assertEquals("", login11.validUser());

    }
}