import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayWithForms {

  // Write a test case in which you navigate to this dummy page:
  //
  // https://getbootstrap.com/docs/5.0/examples/checkout/
  //
  // start to fill in the Billing address form with optional content
  // assert Shipping address is the same as my billing address is not checked
  // check it
  // assert that in Payment section Credit card is chosen
  // choose PayPal
  // assert the background-color of Continue to checkout button
  // assert the text of the Continue to checkout button
  // assert there are 3 item in your cart
  // assert $5 is substracted from Total
  // assert the Total is $20
  // do not fill in CVV field and click Continue to checkout button
  // assert the error message
  // fill in CVV field as well
  // finally click on Continue to checkout button, if you get error message fill in the necessary
  // fields

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.get("https://getbootstrap.com/docs/5.0/examples/checkout/");
    driver.manage().window().maximize();
    driver.navigate().refresh();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
  }

  @Test
  public void playWithForm()  {

    // filling form
    driver.findElement(By.id("firstName")).sendKeys("Kata");
    driver.findElement(By.id("lastName")).sendKeys("Kovari");
    driver.findElement(By.id("username")).sendKeys("kovka");
    driver.findElement(By.id("email")).sendKeys("kovka@gmail.com");
    driver.findElement(By.id("address")).sendKeys("4567 Petofi utca");
    Select country = new Select(driver.findElement(By.id("country")));
    country.selectByVisibleText("United States");
    Select state = new Select(driver.findElement(By.id("state")));
    state.selectByVisibleText("California");
    driver.findElement(By.id("zip")).sendKeys("2345");

    // assertations
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Shipping address is the same as my billing address')]")));
    WebElement sameAddress = driver.findElement(By.xpath("//label[contains(text(),'Shipping address is the same as my billing address')]"));
    assertThat(sameAddress.isSelected())
        .as("Default setup: shipping address is not same with billing address")
        .isFalse();
    // clicking on label instead checkbox
    sameAddress.click();

    assertThat(driver.findElement(By.id("credit")).isSelected())
        .as("Default paying method should be: credit card")
        .isTrue();
    driver.findElement(By.id("paypal")).click();

    WebElement submitButton =
        driver.findElement(By.xpath("//button[contains(text(),'Continue to checkout')]"));
    // background-color assertation, chrome gives back rgba values
    assertThat(submitButton.getCssValue("background-color"))
        .as("Form submit button background color should be: rgb(13, 110, 253)")
        .isEqualTo("rgb(13, 110, 253)");

    WebElement cartItemsNumber =
        driver.findElement(By.xpath("//span[@class='badge bg-primary rounded-pill']"));
    assertThat(cartItemsNumber.getText()).as("Cart items are 3.").isEqualTo("3");

    // strange minus character on page, encoding problem
     WebElement substracted = driver.findElement(By.xpath("//span[@class='text-success']"));
     assertThat(substracted.getText().substring(1)).as("Substraction should be: -$5").isEqualTo("$5");

      WebElement total =
        driver.findElement(By.xpath("//span[contains(text(),'Total (USD)')]/following::strong"));
    assertThat(total.getText()).as("Total should be: $20").isEqualTo("$20");

    driver.findElement(By.id("cc-name")).sendKeys("Kovari Katka");
    driver.findElement(By.id("cc-number")).sendKeys("11111111-22222222");
    driver.findElement(By.id("cc-expiration")).sendKeys("10/2023");

     JavascriptExecutor downAgain = (JavascriptExecutor) driver;
    downAgain.executeScript("window.scrollBy(0, 650)");

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue to checkout')]")));
    submitButton.click();

    WebElement errorMessageCVV =
        driver.findElement(By.xpath("//input[@id='cc-cvv']/following::div"));
    assertThat(errorMessageCVV.getText())
        .as("Error message should be: 'Security code required'")
        .isEqualTo("Security code required");
    driver.findElement(By.id("cc-cvv")).sendKeys("345");

    submitButton.click();

    driver.quit();
  }
}
