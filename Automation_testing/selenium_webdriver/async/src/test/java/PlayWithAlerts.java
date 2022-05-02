import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayWithAlerts {

  // Navigate to to the page: https://www.seleniumeasy.com/test/javascript-alert-box-demo.html
  //
  // Case 1:
  //
  // click on Click me button in the simple alert panel
  // verify the text of the alert then click on OK
  //
  // Case 2:
  //
  // click on Click me button in the confirm panel
  // when the alert appears, click on OK
  // verify that the text "You pressed OK!" appears below
  // click on Click me button again, but this time select the Cancel option
  // verify that the text "You pressed Cancel!" appears below
  //
  // Case 3:
  //
  // click on Click for Prompt Box button in the prompt panel
  // when the alert appears, click on Cancel
  // verify that no message appears below
  // click on button again, write your name to the input field in the alert and click OK
  // verify that the "You have entered 'your name' !" message appears below

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
    driver.manage().window().maximize();
  }

  @Test
  public void playingWithAlerts() {
    // click on alert and verify message
    driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
    Alert alert = driver.switchTo().alert();
    assertThat(alert.getText())
        .as("Alert box text should be: I am an alert box")
        .isEqualTo("I am an alert box!");
    driver.switchTo().alert().accept();

    // click on confirm
    driver
        .findElement(
            By.xpath("//button[@class='btn btn-default btn-lg'][contains(text(),'Click me!')]"))
        .click();
    driver.switchTo().alert().accept();
    WebElement cMessage = driver.findElement(By.id("confirm-demo"));
    assertThat(cMessage.getText())
        .as("Text should be You pressed OK!")
        .isEqualTo("You pressed OK!");
    driver
        .findElement(
            By.xpath("//button[@class='btn btn-default btn-lg'][contains(text(),'Click me!')]"))
        .click();
    driver.switchTo().alert().dismiss();
    WebElement cMessageDismiss = driver.findElement(By.id("confirm-demo"));
    assertThat(cMessageDismiss.getText())
        .as("Text should be You pressed Cancel!")
        .isEqualTo("You pressed Cancel!");

    // click on prompt box
    driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
    driver.switchTo().alert().dismiss();

    WebElement text1 = driver.findElement(By.id("prompt-demo"));
    assertThat(text1.getText()).as("Nothing we should get").isEqualTo("");

    driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
    driver.switchTo().alert().sendKeys("Veres László");
    driver.switchTo().alert().accept();
    WebElement text = driver.findElement(By.id("prompt-demo"));
    assertThat(text.getText())
        .as("Text must be: You have entered 'Veres László' !")
        .isEqualTo("You have entered 'Veres László' !");
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
