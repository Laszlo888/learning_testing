import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagination {

  // Navigate to the page https://computer-database.gatling.io/computers
  // Enter 'ac' to the search field and click on the filter button
  // wait until the number of search results changed
  // paginate through all the results via clicking on the Next button repeatedly
  // wait and verify after each click that the content of the page really changed

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://computer-database.gatling.io/computers");
    driver.manage().window().maximize();
  }

  @Test
  public void loadTillContentExist() {
    String everything =
        driver.findElement(By.xpath("//div[@id='pagination']/ul/li[@class='current']/a")).getText();
    driver.findElement(By.id("searchbox")).sendKeys("ac");
    driver.findElement(By.id("searchsubmit")).click();
    WebDriverWait wait = new WebDriverWait(driver, 6);
    wait.until(
        ExpectedConditions.invisibilityOfElementWithText(
            By.xpath("//div[@id='pagination']/ul/li[@class='current']/a"), everything));


    // pagination, checking a text to change when we are on next page
    String temp;
    do {
      if(driver.findElement(By.xpath("//li[@class='next']")).isDisplayed()){
          temp = driver.findElement(By.xpath("//div[@id='pagination']/ul/li[@class='current']/a")).getText();
          driver.findElement(By.partialLinkText("Next")).click();
          // wait until current text is invisible (so it's changed to next one)
          wait.until(
                  ExpectedConditions.invisibilityOfElementWithText(
                          By.xpath("//div[@id='pagination']/ul/li[@class='current']/a"), temp));
      }
    } while (driver.findElements(By.xpath("//li[@class='next']")).size()==1);
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
