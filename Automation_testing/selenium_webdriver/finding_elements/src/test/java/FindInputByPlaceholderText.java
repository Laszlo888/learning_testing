import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

// Create a function called findByPlaceholderText() which expects
// a WebDriver instance as the first input parameter,and a string representing a placeholder text.
// Return a WebElement of an input field which has the matching placeholder text.
// Throws NoSuchElementException if a matching input field was not found.

public class FindInputByPlaceholderText {

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  WebElement findByPlaceholderText(WebDriver driver, String placeholderText) {
    WebElement findedInputOrTextarea =
        driver.findElement(By.xpath("//*[@placeholder='" + placeholderText + "']"));
    if (findedInputOrTextarea.isDisplayed() || findedInputOrTextarea.isEnabled()) {
      return findedInputOrTextarea;
    } else {
      throw new NoSuchElementException();
    }
  }

  @Test
  public void tryFindByPlaceholderText() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://test-automation-demo.greenfox.academy");
    driver.manage().window().maximize();
    findByPlaceholderText(driver, "name@example.com");
    driver.quit();
  }
}
