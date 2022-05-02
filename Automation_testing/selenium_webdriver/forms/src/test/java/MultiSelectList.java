import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiSelectList {

  // Go to this page: https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html
  //
  // in Select Multiple Values section do single select by
  // selecting Arizona, Georgia, Michigan, each with 3 different type of Select method
  // assert that all of them are in the Selected State textbox
  // deselect all of them with one command
  // do a multiple selection by using Ctrl key and select: Arizona, Kansas, Michigan
  // assert that all of them are in the Selected State textbox

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void multiSelectList() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
    driver.manage().window().maximize();

    // drop down menu, options with two letter values
    WebElement stateDropDown =
        driver.findElement(
            By.xpath("//label[contains(text(),'Select State :')]/following::select[1]"));
    Select sdd = new Select(stateDropDown);
    sdd.selectByVisibleText("Arizona");
    sdd.selectByIndex(10);
    sdd.selectByValue("MI");

    WebElement arizona = driver.findElement(By.xpath("//ul/li[@title='Arizona']"));
    WebElement georgia = driver.findElement(By.xpath("//ul/li[@title='Georgia']"));
    WebElement michigan = driver.findElement(By.xpath("//ul/li[@title='Michigan']"));
    assertThat(arizona.isDisplayed()).as("Arizona should be selected").isTrue();
    assertThat(georgia.isDisplayed()).as("Georgia should be selected").isTrue();
    assertThat(michigan.isDisplayed()).as("Michigan should be selected").isTrue();

    sdd.deselectAll();

    // multiple select using CTRL key
    WebElement stateddInput =
        driver.findElement(By.xpath("//input[@class='select2-search__field']"));
    stateddInput.click();
    Actions action = new Actions(driver);
    action
        .keyDown(Keys.CONTROL)
        .click(driver.findElement(By.xpath("//li[contains(text(),'Arizona')]")))
        .click(driver.findElement(By.xpath("//li[contains(text(),'Kansas')]")))
        .click(driver.findElement(By.xpath("//li[contains(text(),'Michigan')]")))
        .keyUp(Keys.CONTROL)
        .perform();
    WebElement arizona1 = driver.findElement(By.xpath("//ul/li[@title='Arizona']"));
    WebElement kansas = driver.findElement(By.xpath("//ul/li[@title='Kansas']"));
    WebElement michigan2 = driver.findElement(By.xpath("//ul/li[@title='Michigan']"));
    assertThat(arizona1.isDisplayed()).as("Arizona should be selected").isTrue();
    assertThat(kansas.isDisplayed()).as("Kansas should be selected").isTrue();
    assertThat(michigan2.isDisplayed()).as("Michigan should be selected").isTrue();

    driver.quit();
  }
}
