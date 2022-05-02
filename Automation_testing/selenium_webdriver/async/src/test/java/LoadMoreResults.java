import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LoadMoreResults {

  // Navigate to the page https://webscraper.io/test-sites/e-commerce/more/computers/laptops
  // Click on the More button under the products
  // wait until the number of loaded products changed then click on the More button again
  // repeat the above step until there are more products to display
  //
  // Navigate again to the page https://webscraper.io/test-sites/e-commerce/more/computers/laptops
  // Click repeatedly on the More button this time only until a Dell Inspiron 15 laptop appears
  // among the results
  // once it's there, click on it's name and wait and verify that you are redirected to it's product
  // page

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://webscraper.io/test-sites/e-commerce/more/computers/laptops");
    driver.manage().window().maximize();
  }

  @Test
  public void loadTillContentExist() {
    do {
      driver.findElement(By.linkText("More")).click();
    } while (!driver.findElement(By.linkText("More")).isDisplayed());
  }

  @Test
  public void searchingDellInspiron15AndClickIt() {
    // searching with findelements doesn't throw NoSuchElementException, it gives a zero size list
    if (driver.findElements(By.partialLinkText("Dell Inspiron 15")).size() > 0) {
      driver.findElement(By.partialLinkText("Dell Inspiron 15")).click();
    } else {
      do {
        driver.findElement(By.linkText("More")).click();
      } while (driver.findElements(By.partialLinkText("Dell Inspiron 15")).size() == 0);
      driver.findElement(By.partialLinkText("Dell Inspiron 15")).click();
    }
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    String url = driver.getCurrentUrl();
    assertThat(url.contains("product")).as("Product page should be opened.").isTrue();
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
