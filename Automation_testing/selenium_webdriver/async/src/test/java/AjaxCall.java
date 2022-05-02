import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Navigate to the page: http://uitestingplayground.com/ajax
// Click on the button on the page and wait until the "Data loaded with AJAX get request." message
// appears

public class AjaxCall {

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void verifyAjaxCall() {
    WebDriver driver = new ChromeDriver();
    driver.get("http://uitestingplayground.com/ajax");
    driver.manage().window().maximize();

    driver.findElement(By.id("ajaxButton")).click();

    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='bg-success']")));

    driver.quit();
  }
}
