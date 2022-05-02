import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

// Navigate to this page: https://www.saucedemo.com/
// After a successful login (with the given credentials) print the name of the cookies available on
// the site
//
// If there are multiple cookies try to figure out which one of these cookies is the session cookie
// based on it's name.
//
// Delete the session cookie by its name
// Reload the page
// Assert that with the session cookie deleted the browser is redirected back to the login page

public class GetCookies {

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();

    // sign in
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("footer")));
  }

  @Test
  public void finAndDeleteSessionCookie() {

    // cookies saved in a set and print their names
    Set<Cookie> allCookies = driver.manage().getCookies();
    Iterator<Cookie> it = allCookies.iterator();
    while (it.hasNext()) {
      System.out.println();
      System.out.println(it.next().getName());
      System.out.println();
    }
    // delete session cookie
    driver.manage().deleteCookieNamed("session-username");
    // refresh page
    driver.navigate().refresh();
    // check we are logged out because session cookie was deleted
    assertThat(driver.getCurrentUrl()).isEqualTo("https://www.saucedemo.com/");
  }

  // Create a new test case to test if the logout button actually logs out the user.
  //
  // Navigate to the same page as in the previous exercise
  // After a successful login (with the given credentials) locate the logout button
  // Click the logout button
  // Assert that the session cookie is deleted after a successful logout

  @Test
  public void checkLogOutButton() {
    driver.findElement(By.id("react-burger-menu-btn")).click();
    WebDriverWait wait = new WebDriverWait(driver, 8);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));
    driver.findElement(By.id("logout_sidebar_link")).click();

    Set<Cookie> allCookies = driver.manage().getCookies();

    boolean isSessionCookie = false;
    if (allCookies.size() > 0) {
      Iterator<Cookie> it = allCookies.iterator();
      while (it.hasNext()) {
        if (it.next().getName().equals("session-username")) {
          isSessionCookie = true;
        }
      }
    }
    assertThat(isSessionCookie).isFalse();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
