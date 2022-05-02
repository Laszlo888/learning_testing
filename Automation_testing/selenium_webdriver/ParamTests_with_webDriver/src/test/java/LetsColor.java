import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

// Navigate to this page: https://courses.letskodeit.com/practice
// Color with a 3px wide yellow border the Enter your name field using JavaScriptExecutor
// "arguments[0].style.border='3px solid yellow';"
// Enter your name using script: "arguments[0].value='your name';"
// Click on the Confirm button using the JavaScriptExecutor
// Dismiss the alert using Alert
// Switch to the iframe in the iFrame Example section
// Scroll down vertically 300px using the JavaScriptExecutor, "window.scrollBy(..,..)"
// Scroll down until Terms & Conditions link is visible using the JavaScriptExecutor
// Color it with a green dotted border
// Switch back to parent frame and color the background of the Hide/Show Example field to red

public class LetsColor {

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://courses.letskodeit.com/practice");
    driver.manage().window().maximize();
  }

  @Test
  public void switchToIframeAndPlayWithJavascriptExecutor() throws InterruptedException {

    WebElement enterName =
        driver.findElement(By.xpath("//div[@class='right-align']//fieldset//input[@id='name']"));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].style.border='3px solid yellow';", enterName);
    Thread.sleep(3000);
    js.executeScript("arguments[0].value='Veres László';", enterName);
    Thread.sleep(3000);
    WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
    js.executeScript("arguments[0].click();", confirmButton);
    Thread.sleep(3000);
    Alert alert = driver.switchTo().alert();
    alert.dismiss();

    // switch to iframe by id
    driver.switchTo().frame("courses-iframe");
    js.executeScript("window.scrollBy(0,300)");
    Thread.sleep(3000);
    WebElement termsCond = driver.findElement(By.linkText("Terms & Conditions"));
    js.executeScript("arguments[0].scrollIntoView(true);", termsCond);
    Thread.sleep(3000);
    js.executeScript("arguments[0].style.border='dotted green';", termsCond);
    Thread.sleep(3000);

    // switch back to parent window
    driver.switchTo().parentFrame();
    WebElement hideShow = driver.findElement(By.id("displayed-text"));
    js.executeScript("arguments[0].style.backgroundColor = 'red';", hideShow);
    Thread.sleep(3000);
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
