import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

// Navigate to this page: http://demo.guru99.com/popup.php
// Click the Click Here button 3 times
// Store the parent window handle
// Store all the windows opened
// Enter a fake email to the input field in each window and click the Submit button
// Switch to the parent window and close it

public class MultipleWindowsHandling extends BaseTest {

  @BeforeEach
  void setup() {
    driver.get("http://demo.guru99.com/popup.php");
    driver.manage().window().maximize();
  }

  @Test
  public void openNewWindowsAndSwitchingAndActing() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Click Here")));

    // opening 3 new window
    driver.findElement(By.linkText("Click Here")).click();
    driver.findElement(By.linkText("Click Here")).click();
    driver.findElement(By.linkText("Click Here")).click();

    // get parent window(current window)
    String parentWindow = driver.getWindowHandle();
    // get all window which are
    Set<String> allWindowsOpened = driver.getWindowHandles();

    // iterate through windows and fill email field
    Iterator<String> i = allWindowsOpened.iterator();
    while (i.hasNext()) {
      String child_window = i.next();
      if (!parentWindow.equals(child_window)) {
        driver.switchTo().window(child_window);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("valami@akarmi.hu");
        driver.findElement(By.xpath(("//input[@type='submit']"))).click();
      }
    }

    driver.switchTo().window(parentWindow);
  }
}
