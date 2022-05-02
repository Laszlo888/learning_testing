package pageTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {
  @Test
  public void isRegistered() {
    registrationPage.open();
    Assertions.assertTrue(registrationPage.isLoaded());
    registrationPage.registration(
        "Róbert", "Károly", "Asdfghj1", "karolyrob@gmail.com", "+3630222222");
    Assertions.assertTrue(registrationSuccessPage.isLoaded());
  }
}
