import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

  WebDriver driver;

  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement firstNameField() {
    return driver.findElement(By.id("input-firstname"));
  }

  public WebElement lastNameField() {
    return driver.findElement(By.id("input-lastname"));
  }

  public WebElement emailField() {
    return driver.findElement(By.id("input-email"));
  }

  public WebElement telephoneField() {
    return driver.findElement(By.id("input-telephone"));
  }

  public WebElement passwordField() {
    return driver.findElement(By.id("input-password"));
  }

  public WebElement passwordConfirmField() {
    return driver.findElement(By.id("input-confirm"));
  }

  public WebElement agreeTermsCheckbox() {
    return driver.findElement(By.xpath("//input[@type='checkbox']"));
  }

  public WebElement continueButton() {
    return driver.findElement(By.xpath("//input[@type='submit']"));
  }

  public void open() {
    driver.get("https://demo.opencart.com/index.php?route=account/register");
    driver.manage().window().maximize();
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
