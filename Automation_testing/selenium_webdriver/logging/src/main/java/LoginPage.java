import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

  private static final Logger loginPage = LoggerFactory.getLogger(LoginPage.class);

  WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getUsernameField() {
    return driver.findElement(By.id("input-email"));
  }

  public WebElement getPasswordField() {
    return driver.findElement(By.id("input-password"));
  }

  public WebElement getLoginButton() {
    return driver.findElement(By.xpath("//input[@type='submit']"));
  }

  public void open() {
    driver.get("https://demo.opencart.com/index.php?route=account/login");
    driver.manage().window().maximize();
  }

  public boolean isLoaded() {
    return this.getLoginButton().isDisplayed();
  }

  public void login(String username, String password) {
    loginPage.debug("username input");
    getUsernameField().sendKeys(username);
    loginPage.debug("password input");
    getPasswordField().sendKeys(password);
    loginPage.debug("click login button");
    getLoginButton().click();
  }
}
