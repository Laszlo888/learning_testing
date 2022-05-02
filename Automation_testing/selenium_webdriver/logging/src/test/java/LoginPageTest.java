import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseTest {

  private static final Logger LOG = LoggerFactory.getLogger(LoginPageTest.class);

  @Test
  public void isLogin() {

    LoginPage loginPage = new LoginPage(driver);
    LOG.info("opening page");
    loginPage.open();
    LOG.debug("login page is loaded");
    Assertions.assertThat(loginPage.isLoaded()).isTrue();
    LOG.trace("username: vereslaszlo34@gmail.com");
    LOG.trace("password: Asdfghj1");
    loginPage.login("vereslaszlo34@gmail.com", "Asdfghj1");
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    LoginSuccessPage myAccount = new LoginSuccessPage(driver);
    LOG.debug("login successful");
    Assertions.assertThat(myAccount.isLoaded()).isTrue();
  }
}
