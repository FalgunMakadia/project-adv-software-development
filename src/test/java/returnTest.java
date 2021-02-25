import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class returnTest {
    @Test
    public void returnTest()
    {
        Login l = new Login();
        assertEquals(10, l.test());

    }

}
