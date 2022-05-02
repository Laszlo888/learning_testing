import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends BaseTest{
    @Test
    public void isRegistered()  {
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.open();
        Assertions.assertThat(regPage.isLoaded()).isTrue();
        regPage.registration("Róbert", "Károly","Asdfghj1","karolyrob@gmail.com","+3630222222");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        RegistrationSuccessPage regSuc = new RegistrationSuccessPage(driver);
        Assertions.assertThat(regSuc.isLoaded()).isTrue();
    }
}
