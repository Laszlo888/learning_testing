import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class Hover {

  // Create a test case and navigate to this page:
  //
  // http://the-internet.herokuapp.com/hovers
  //
  // move the mouse cursor above the second picture
  // assert that the words below the image are displayed when the mouse cursor is over the second
  // picture

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("http://the-internet.herokuapp.com/hovers");
    driver.manage().window().maximize();
  }

  @Test
  public void checkingDisplayedWordsAfterHovering() {

    WebElement picture = driver.findElement(By.xpath("//div[@class='figure'][2]/img"));

    Actions action = new Actions(driver);
    action.moveToElement(picture).build().perform();

    WebElement wordsUnderPicture =
        driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
    assertThat(wordsUnderPicture.isDisplayed())
        .as("After move cursor above picture words must be displayed at the bottom of picture")
        .isTrue();
  }
}
