package pageTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest{

    @Test
    public void isLogin()  {
        loginPage.open();
        Assertions.assertTrue(loginPage.isLoaded());
        loginPage.login("vereslaszlo34@gmail.com", "Asdfghj1");
        Assertions.assertTrue(myAccount.isLoaded());
    }
}
