import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicSmokeTest {

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void siteIsUpOrNot() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://index.hu");
    driver.manage().window().maximize();
    // felugró ablak
    driver.findElement(By.xpath("//button[@aria-label='ELFOGADOM']")).click();

    // url checking
    assertThat(driver.getCurrentUrl())
        .as("Url should be 'https://index.hu/'")
        .isEqualTo("https://index.hu/");

    // index logo displayed or not
    WebElement logo = driver.findElement(By.xpath("//a[@data-ga-category='Index logó']"));
    assertThat(logo.isDisplayed()).as("Main logo should be displayed.").isTrue();

    driver.quit();
  }

  @Test
  public void checkingLinksWithEmptyStringOrNull() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://index.hu");
    driver.manage().window().maximize();
    // felugró ablak
    driver.findElement(By.xpath("//button[@aria-label='ELFOGADOM']")).click();
    // checking for link with empty href
    List<WebElement> linkS = driver.findElements(By.xpath("//a[@href='' or @href=null]"));
    assertThat(linkS.size()).as("We found some bad links.").isEqualTo(0);

    driver.quit();
  }
}
