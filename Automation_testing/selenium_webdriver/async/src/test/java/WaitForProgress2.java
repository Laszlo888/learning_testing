import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class WaitForProgress2 {

  // navigate to the page: https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html
  // click on the Start Download button
  // verify that the download modal opened
  // wait until all these conditions are fulfilled:
  // the Complete! text is visible
  // the progress bar reached the end
  // and the Close button appears
  // then close the modal
  // and verify that the modal is not visible anymore

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
    driver.manage().window().maximize();
  }

  @Test
  public void usingAndInWaiting() {
    driver.findElement(By.id("downloadButton")).click();

    // download window opened or not
    WebDriverWait wait = new WebDriverWait(driver, 5);
    WebElement downloadWindow =
        driver.findElement(By.xpath("//span[contains(text(),'File Download')]"));
    wait.until(ExpectedConditions.textToBePresentInElement(downloadWindow, "File Download"));

    // using 'and' at waiting
    WebDriverWait wait2 = new WebDriverWait(driver, 15);
    wait2.until(
        ExpectedConditions.and(
            ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='progress-label']"), "Complete!"),
            ExpectedConditions.attributeToBe(By.id("progressbar"), "aria-valuenow", "100"),
            ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='ui-dialog-buttonset']/button"), "Close")));

    //close and verify download window is not there
    driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button")).click();
    assertThat(downloadWindow.isDisplayed()).isFalse();
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
