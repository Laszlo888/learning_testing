import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

// Create a test case and navigate to this page:
//
// https://www.saucedemo.com/
//
// assert that the username field isDisplayed() on the page
// enter any accepted username
// assert that the password field isDisplayed() on the page
// enter the correct password
// assert that the login button isDisplayed() on the page
// log in
// log out

public class Login {

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void logInlogOut() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();

    // verify username field
    WebElement userField = driver.findElement(By.id("user-name"));
    assertThat(userField.isDisplayed()).as("User name field should be displayed").isTrue();
    userField.sendKeys("standard_user");

    // verify password field
    WebElement pwField = driver.findElement(By.id("password"));
    assertThat(pwField.isDisplayed()).as("Password field should be displayed").isTrue();
    pwField.sendKeys("secret_sauce");

    // click login button
    driver.findElement(By.id("login-button")).click();

    // click to open menu for log out
    driver.findElement(By.id("react-burger-menu-btn")).click();

    // click log out
    driver.findElement(By.id("logout_sidebar_link")).click();

    driver.quit();
  }
}
