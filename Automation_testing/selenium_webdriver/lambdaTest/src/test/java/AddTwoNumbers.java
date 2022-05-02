import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

// Navigate to this page: https://www.seleniumeasy.com/test/basic-first-form-demo.html
// Create a parameterized test based on this CSV file
// At the Two Input Fields section enter the first and second data to the given fields
// Click the Get Total button
// Assert that the result displayed on the page matches the result column of the CSV file

public class AddTwoNumbers {

  public RemoteWebDriver driver = null;
  // username and accesskey for lambdatest site
  String userName;
  String accessKey;

  // read the content of property file
  {
    try {
      Properties properties = new Properties();
      InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");

      try {

        properties.load(propertiesStream);

      } catch (IOException ex) {
        ex.printStackTrace();
      }

      accessKey = properties.getProperty("accessKey");
      userName = properties.getProperty("username");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @BeforeEach
  void setup() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platform", "Windows 10");
    capabilities.setCapability("browserName", "Firefox");
    capabilities.setCapability(
        "version", "90.0"); // If this cap isn't specified, it will just get the any available one
    capabilities.setCapability("resolution", "1920x1080");
    capabilities.setCapability("build", "Add two numbers parameterized test");
    capabilities.setCapability("name", "Add two number");
    capabilities.setCapability("network", true); // To enable network logs
    capabilities.setCapability("visual", true); // To enable step by step screenshot
    capabilities.setCapability("video", true); // To enable video recording
    capabilities.setCapability("console", true); // To capture console logs

    try {
      driver =
          new RemoteWebDriver(
              new URL("https://" + userName + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
              capabilities);
    } catch (MalformedURLException e) {
      System.out.println("Invalid grid URL");
    }
  }

  @ParameterizedTest
  @Description("Add two number and check the results.")
  @CsvFileSource(resources = "addTwoNumber.csv", numLinesToSkip = 1)
  public void successRegistrations(String number1, String number2, String result) {
    driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    WebDriverWait wait = new WebDriverWait(driver, 10);

    wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='at-cv-lightbox-button-holder']/a[2]")))
        .click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sum1")));

    driver.findElement(By.id("sum1")).sendKeys(number1);
    driver.findElement(By.id("sum2")).sendKeys(number2);

    driver.findElement(By.xpath("//button[contains(text(),'Get Total')]")).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("displayvalue")));
    WebElement resUlt = driver.findElement(By.id("displayvalue"));
    assertThat(resUlt.getText()).isEqualTo(result);
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
