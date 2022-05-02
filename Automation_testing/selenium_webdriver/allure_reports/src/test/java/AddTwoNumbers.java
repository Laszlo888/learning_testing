import jdk.jfr.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

// Navigate to this page: https://www.seleniumeasy.com/test/basic-first-form-demo.html
// Create a parameterized test based on this CSV file
// At the Two Input Fields section enter the first and second data to the given fields
// Click the Get Total button
// Assert that the result displayed on the page matches the result column of the CSV file

public class AddTwoNumbers extends BaseTest {

  @ParameterizedTest
  @Description("Add two number and check the results.")
  @CsvFileSource(resources = "addTwoNumber.csv", numLinesToSkip = 1)
  public void successRegistrations(String number1, String number2, String result) {
    driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='at-cv-lightbox-button-holder']/a[2]"))).click();


    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sum1")));

    driver.findElement(By.id("sum1")).sendKeys(number1);
    driver.findElement(By.id("sum2")).sendKeys(number2);

    driver.findElement(By.xpath("//button[contains(text(),'Get Total')]")).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("displayvalue")));
    WebElement resUlt = driver.findElement(By.id("displayvalue"));
    assertThat(resUlt.getText()).isEqualTo(result);
  }
}
