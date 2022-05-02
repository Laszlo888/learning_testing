import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

// Navigate to this page: https://nxtgenaiacademy.com/demo-site/
// Make a CSV file and fill it up with your own test data
// You only have to fill the required fields, so 4 columns are enough
// Create 5 parameterized test based on your own CSV file and make registration attempts (in every
// test click on the Submit button)
// Assert in each case that the registration was successful

public class ParameterizedRegistrationTest  {
  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://nxtgenaiacademy.com/demo-site/");
    driver.manage().window().maximize();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "registration.csv", numLinesToSkip = 1)
  public void successRegistrations(
      String userName, String lastName, String gender, String email, String number) {

    driver.findElement(By.id("vfb-5")).sendKeys(userName);
    driver.findElement(By.id("vfb-7")).sendKeys(lastName);
    if (gender.equals("male")) {
      driver.findElement(By.id("vfb-8-1")).click();
    } else {
      driver.findElement(By.id("vfb-8-2")).click();
    }
    driver.findElement(By.id("vfb-14")).sendKeys(email);
    driver.findElement(By.id("vfb-3")).sendKeys(number);
    driver.findElement(By.id("vfb-4")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(
        ExpectedConditions.presenceOfElementLocated(
            By.xpath(
                "//div[contains(text(),'Your query successfully submitted. Please check yo')]")));
    WebElement successMessage =
        driver.findElement(
            By.xpath(
                "//div[contains(text(),'Your query successfully submitted. Please check yo')]"));
    assertThat(successMessage.getText())
        .isEqualTo(
            "Your query successfully submitted. Please check your mail box. Click on Home page to know more about latest updates.");
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
