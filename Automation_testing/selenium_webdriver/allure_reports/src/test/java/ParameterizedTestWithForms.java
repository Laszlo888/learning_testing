import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Muted;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

// Navigate to this site: https://www.saucedemo.com/
// Do a parameterized test and use this CSV file.
// Do login attempts with every item from the file
// Be careful not to enter header data

public class ParameterizedTestWithForms extends BaseTest {

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "source.csv", numLinesToSkip = 1)
  public void badLoginAttempts(String userName, String passWord) {

    driver.findElement(By.id("user-name")).sendKeys(userName);
    driver.findElement(By.id("password")).sendKeys(passWord);
    driver.findElement(By.id("login-button")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
    WebElement errorMessage = driver.findElement(By.tagName("h3"));
    assertThat(errorMessage.getText())
        .isEqualTo("Epic sadface: Username and password do not match any user in this service");
  }
  public byte[] screenshot(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }


  @AfterEach
  public void tearDown() {
    saveScreenshot(screenshot(driver));
    driver.close();
  }
}
