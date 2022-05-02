package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

  public WebElement getUsernameField() {
    return $(By.id("input-email"));
  }

  public WebElement getPasswordField() {
    return $(By.id("input-password"));
  }

  public WebElement getLoginButton() {
    return $(By.xpath("//input[@type='submit']"));
  }

  public void open() {
    Configuration.startMaximized = true;
    Selenide.open("https://demo.opencart.com/index.php?route=account/login");
  }

  public boolean isLoaded() {
    return $(getLoginButton()).isDisplayed();
  }

  public void login(String username, String password) {
    getUsernameField().sendKeys(username);
    getPasswordField().sendKeys(password);
    getLoginButton().click();
  }
}
