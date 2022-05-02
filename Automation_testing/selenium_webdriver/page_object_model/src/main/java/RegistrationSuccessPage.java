import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationSuccessPage {

  WebDriver driver;

  public RegistrationSuccessPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement successRegistration() {
    return driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
  }

  public boolean isLoaded() {
    return successRegistration().isDisplayed();
  }
}
