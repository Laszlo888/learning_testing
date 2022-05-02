import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidLogin {

  // Create a test case and navigate to this page:
  //
  // https://www.saucedemo.com/
  //
  // leave the username field empty and fill in the password field, click login
  // assert that the error message is displayed on the page
  // leave the password field empty and fill in the username field, click login
  // assert that the error message is displayed on the page
  // enter an accepted username and a wrong password, click login
  // assert that the error message is displayed on the page

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void badLogInAttempts() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();

    // verify password field
    WebElement pwField = driver.findElement(By.id("password"));
    assertThat(pwField.isDisplayed()).as("Password field should be displayed").isTrue();
    pwField.sendKeys("secret_sauce");

    // click login button
    driver.findElement(By.id("login-button")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@data-test='error']")));

    // find error message and asserting it
    String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    assertThat(errorMessage)
        .as("Error message is not right.")
        .isEqualTo("Epic sadface: Username is required");

    // clear password field and refresh page to forget password, after refresh we need to find our elements again
    pwField.clear();
    driver.navigate().refresh();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));

    // verify username field
    WebElement userField = driver.findElement(By.id("user-name"));
    assertThat(userField.isDisplayed()).as("User name field should be displayed").isTrue();
    userField.sendKeys("standard_user");

    // click login button
    driver.findElement(By.id("login-button")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@data-test='error']")));

    // find error message and asserting it
    String errorMess = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    assertThat(errorMess)
        .as("Error message is not right.")
        .isEqualTo("Epic sadface: Password is required");

    // enter bad password
    WebElement pawField = driver.findElement(By.id("password"));
    assertThat(pawField.isDisplayed()).as("Password field should be displayed").isTrue();
    pawField.sendKeys("blablabla");

    // click login button
    driver.findElement(By.id("login-button")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@data-test='error']")));

    // find error message and asserting it
    String errorMes = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    assertThat(errorMes)
        .as("Error message is not right.")
        .isEqualTo("Epic sadface: Username and password do not match any user in this service");

    driver.quit();
  }
}
