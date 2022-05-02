import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSuccessPage {

  WebDriver driver;

  public LoginSuccessPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement successLogin() {
    return driver.findElement(By.linkText("Edit your account information"));
  }

  public boolean isLoaded() {
    return successLogin().isDisplayed();
  }
}
