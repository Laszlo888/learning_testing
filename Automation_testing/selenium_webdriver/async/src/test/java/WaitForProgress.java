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

public class WaitForProgress {

  // navigate to the page: https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html
  // click on the Start Download button
  // verify that the download modal opened
  // wait until the close button appears
  // then click on it
  // and verify that the modal is not visible anymore

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void testDownloadWindowAppearAndDisappear() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
    driver.manage().window().maximize();

    driver.findElement(By.id("downloadButton")).click();

    // download window opened or not
    WebDriverWait wait = new WebDriverWait(driver, 5);
    WebElement downloadWindow =
        driver.findElement(By.xpath("//span[contains(text(),'File Download')]"));
    wait.until(ExpectedConditions.textToBePresentInElement(downloadWindow, "File Download"));

    // waiting for download is finished
    WebDriverWait waitForCancelButton = new WebDriverWait(driver, 15);
    waitForCancelButton
        .until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(text(),'Close')]")))
        .click();

    // windows is closed or not after clicking close button
    assertThat(downloadWindow.isDisplayed())
        .as("File download window should be disappeared")
        .isFalse();

    driver.quit();
  }
}
