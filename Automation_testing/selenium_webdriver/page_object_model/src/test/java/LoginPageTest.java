import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseTest{

    @Test
    public void isLogin()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assertions.assertThat(loginPage.isLoaded()).isTrue();
        loginPage.login("vereslaszlo34@gmail.com", "Asdfghj1");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        LoginSuccessPage myAccount = new LoginSuccessPage(driver);
        Assertions.assertThat(myAccount.isLoaded()).isTrue();
    }
}
