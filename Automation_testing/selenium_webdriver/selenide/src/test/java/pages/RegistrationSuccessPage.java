package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationSuccessPage {

  public WebElement successRegistration() {
    return $(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
  }

  public boolean isLoaded() {
    return successRegistration().isDisplayed();
  }
}
