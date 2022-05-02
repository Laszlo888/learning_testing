import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxCall2 {

  // go back to your Ajax call exercise and after your first click and wait click on the button
  // again and wait and verify that a second success message shows up as well.
  //
  // Refactor your code so that the verification would work with any number of repeated
  // clicks/messages

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("http://uitestingplayground.com/ajax");
    driver.manage().window().maximize();
  }

  @ParameterizedTest
  @ValueSource(ints = {4})
  public void clickingAjaxMoreTimes(int clickNumber) {
    for (int i = 1; i < clickNumber + 1; i++) {
      driver.findElement(By.id("ajaxButton")).click();
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(
          ExpectedConditions.presenceOfElementLocated( By.xpath("//div[@id='content']/p[" + i + "]")));
    }
    driver.quit();
  }
}
