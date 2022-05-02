package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

  public WebElement firstNameField() {
    return $(By.id("input-firstname"));
  }

  public WebElement lastNameField() {
    return $(By.id("input-lastname"));
  }

  public WebElement emailField() {
    return $(By.id("input-email"));
  }

  public WebElement telephoneField() {
    return $(By.id("input-telephone"));
  }

  public WebElement passwordField() {
    return $(By.id("input-password"));
  }

  public WebElement passwordConfirmField() {
    return $(By.id("input-confirm"));
  }

  public WebElement agreeTermsCheckbox() {
    return $(By.xpath("//input[@type='checkbox']"));
  }

  public WebElement continueButton() {
    return $(By.xpath("//input[@type='submit']"));
  }

  public void open() {
    Configuration.startMaximized = true;
    Selenide.open("https://demo.opencart.com/index.php?route=account/register");
  }

  public boolean isLoaded() {
    return agreeTermsCheckbox().isDisplayed();
  }

  public void registration(
      String firstName, String lastName, String password, String email, String phoneNumber) {

    firstNameField().sendKeys(firstName);
    lastNameField().sendKeys(lastName);
    emailField().sendKeys(email);
    telephoneField().sendKeys(phoneNumber);
    passwordField().sendKeys(password);
    passwordConfirmField().sendKeys(password);
    agreeTermsCheckbox().click();
    continueButton().click();
  }
}
