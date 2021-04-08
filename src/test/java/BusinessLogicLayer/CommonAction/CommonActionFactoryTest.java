package BusinessLogicLayer.CommonAction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonActionFactoryTest {

    @Test
    void createSignOutAction() {
        CommonActionFactory  commonActionFactory = new CommonActionFactory();
        IAbstractAction signOut = commonActionFactory.createSignOutAction();
        assertEquals("Sign Out",signOut.getActionTitle());
    }
}