import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayWithButtons {

  // Part 1:
  //
  // navigate to the page: https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html
  // click on all four buttons in sequence
  // at the end verify that the "All Buttons Clicked" text appears
  //
  // Part 2:
  //
  // navigate to the page: https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
  // click on all four buttons in order
  // at the end verify that the "All Buttons Clicked" text appears
  //
  // Use appropriate waits in both cases

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
    driver.manage().window().maximize();
  }

  @Test
  public void playingWithButtons() {

    // dynamic buttons
    WebDriverWait wait = new WebDriverWait(driver, 7);
    driver.findElement(By.id("button00")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("button01"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();
    wait.until(
        ExpectedConditions.textToBePresentInElementLocated(
            By.id("buttonmessage"), "All Buttons Clicked"));

    
    // disabled dynamic buttons
    driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
    driver.manage().window().maximize();
    WebDriverWait waitDisabledButtons = new WebDriverWait(driver, 10);
    waitDisabledButtons.until(ExpectedConditions.elementToBeClickable(By.id("button00"))).click();
    waitDisabledButtons.until(ExpectedConditions.elementToBeClickable(By.id("button01"))).click();
    waitDisabledButtons.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();
    waitDisabledButtons.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();
    waitDisabledButtons.until(
        ExpectedConditions.textToBePresentInElementLocated(
            By.id("buttonmessage"), "All Buttons Clicked"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
