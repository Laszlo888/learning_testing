import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

// Create a function called findByButtonText() which expects a WebDriver instance as the first input
// parameter,
// and a string representing a button text.
// Return a WebElement of a button which has the matching text.
// Throws NoSuchElementException if no matching button was found.

public class FindByButtonText {

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  WebElement findByButtonText(WebDriver driver, String buttonText) {
    WebElement findedButton =
        driver.findElement(By.xpath("//button[contains(text() ,'" + buttonText + "')]"));
    if (findedButton.isDisplayed() || findedButton.isEnabled()) {
      return findedButton;
    } else {
      throw new NoSuchElementException();
    }
  }

  @Test
  public void tryFindByButtonText() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://test-automation-demo.greenfox.academy");
    driver.manage().window().maximize();
    WebElement findedInput = findByButtonText(driver, "Sign up");
    System.out.println("Button text is: " + findedInput.getText());
    driver.quit();
  }
}
