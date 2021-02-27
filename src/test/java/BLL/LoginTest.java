package BLL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    Login login1 = new Login("admin", "admin");
    Login login2 = new Login("abc", "abc");

    @Test
    void validUser() {
        assertEquals(true, login1.validUser());
    }

    @Test
    void invalidUserTest() {
        assertEquals(false, login2.validUser());
    }
}