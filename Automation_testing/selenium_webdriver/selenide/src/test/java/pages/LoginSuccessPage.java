package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginSuccessPage {

  public WebElement successLogin() {
    return $(By.linkText("Edit your account information"));
  }

  public boolean isLoaded() {
    return successLogin().isDisplayed();
  }
}
