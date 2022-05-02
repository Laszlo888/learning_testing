package pageTests;

import org.junit.jupiter.api.TestInstance;
import pages.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

  LoginPage loginPage = new LoginPage();
  LoginSuccessPage myAccount = new LoginSuccessPage();
  RegistrationPage registrationPage = new RegistrationPage();
  RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();
  TopNavigation topNavigation = new TopNavigation();
  BlogPage blogPage = new BlogPage();

}
