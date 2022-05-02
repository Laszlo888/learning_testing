import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class Shopping {

  // Go to http://automationpractice.com/index.php
  // Add the "Faded Short Sleeve T-shirts" to the cart
  // Go to the shopping cart summary page
  // Change the quantity from 1 to 3
  // Validate the total price
  // Proceed to checkout
  // Create account
  // Fill in the personal information
  // Continue through the steps
  // Accept terms & conditions
  // Choose pay by check
  // And finally confirm your order
  // Verify that the order was successful


  // Shopping again
  //
  // revisit your Shopping exercise and update your test to use explicit waits whereever it's necessary
  // add some extra steps: after selecting the first product select a second product as well,
  // then delete it from the cart summary.
  // Verify if the product is no longer in the cart and the total price is updated correctly
  // add any other teststeps of your choice


  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().maximize();
    driver.navigate().refresh();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/img[@title='Faded Short Sleeve T-shirts']")));
  }

  @Test
  public void shopping() {

    // add T-shirt
    WebElement imgTshirt =
        driver.findElement(By.xpath("//a/img[@title='Faded Short Sleeve T-shirts']"));
    Actions action = new Actions(driver);
    action.moveToElement(imgTshirt).perform();
    driver.findElement(By.xpath("//a[@data-id-product='1']")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(
            ExpectedConditions.textToBePresentInElementLocated(
                    By.xpath("//span[contains(text(),'Proceed to checkout')]"),"Proceed to checkout"));


    // continue shopping
    WebElement blouse =
            driver.findElement(By.xpath("//a/img[@title='Blouse']"));
    driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/img[@title='Blouse']")));
    action.moveToElement(blouse).perform();
    driver.findElement(By.xpath("//a[@data-id-product='2']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Proceed to checkout')]"))).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='cart_quantity_up_1_1_0_0']//span//i[@class='icon-plus']")));


    // add 2 more T-shirt and delete second one cloth
    WebElement quantityRaiserIcon = driver.findElement(By.xpath("//a[@id='cart_quantity_up_1_1_0_0']//span//i[@class='icon-plus']"));
    quantityRaiserIcon.click();
    wait.until(ExpectedConditions.attributeContains(By.xpath("//td[@class='cart_quantity text-center']//input[@type='hidden']"),"value","2"));
    quantityRaiserIcon.click();
    wait.until(ExpectedConditions.attributeContains(By.xpath("//td[@class='cart_quantity text-center']//input[@type='hidden']"),"value","3"));
    driver.findElement(By.xpath("//a[@id='2_7_0_0']//i[@class='icon-trash']")).click();
    wait.until(ExpectedConditions.and(
            ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@id='total_price']"),"$51.53"),
            ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='2_7_0_0']//i[@class='icon-trash']"))));

    // click to proceed
    driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='SubmitCreate']/span")));

    // fill e-mail and click create account (2 possibilities: success or error)
    driver.findElement(By.id("email_create")).sendKeys("pppp@hjk.hu");
    driver.findElement(By.xpath("//*[@id='SubmitCreate']/span")).click();
    wait.until(ExpectedConditions.or(
            ExpectedConditions.presenceOfElementLocated(By.id("create_account_error")),
            ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname"))));

    // fill form and click register button
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));
    driver.findElement(By.id("customer_firstname")).sendKeys("Zsolt");
    driver.findElement(By.id("customer_lastname")).sendKeys("Kovacs");
    driver.findElement(By.id("passwd")).sendKeys("weRtz4ui");
    driver.findElement(By.id("address1")).sendKeys("2323 Fa utca 2.");
    driver.findElement(By.id("city")).sendKeys("Zoldteto");
    WebElement stateDropDown = driver.findElement(By.id("id_state"));
    Select sdd = new Select(stateDropDown);
    sdd.selectByIndex(8);
    driver.findElement(By.id("postcode")).sendKeys("77777");
    driver.findElement(By.id("phone_mobile")).sendKeys("+985874123658");
    driver.findElement(By.id("alias")).sendKeys("alias");
    driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")));

    // address, proceed
    driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cgv\"]")));

    // accept terms and proceed
    driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")));

    // choose pay by check
    driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cart_navigation\"]/button/span")));

    // confirm order
    driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/p[1]")));

    // assert order
    WebElement verify = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
    assertThat(verify.getCssValue("background-color"))
        .as("Background-color should be: rgba(85, 198, 94, 1)")
        .isEqualTo("rgba(85, 198, 94, 1)");

    // we should delete our account but webpage doesn't contain this feature

    driver.quit();
  }
}
