import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.driver;

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

  @BeforeEach
  void setup() {

    Configuration.startMaximized = true;
    Selenide.open("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
  }

  @Test
  public void playingWithAlerts() {
    // click on alert and verify message
    $(By.xpath("//button[@class='btn btn-default']")).click();
    String alertText = driver().switchTo().alert().getText();
    Assertions.assertEquals("I am an alert box!", alertText);
    driver().switchTo().alert().accept();
  }

  @Test
  public void playWithAlert2() {
    // click on confirm
    $(By.xpath("//button[@class='btn btn-default btn-lg'][contains(text(),'Click me!')]")).click();
    driver().switchTo().alert().accept();
    WebElement cMessage = $(By.id("confirm-demo"));
    $(cMessage).should(Condition.exactText("You pressed OK!"));

    $(By.xpath("//button[@class='btn btn-default btn-lg'][contains(text(),'Click me!')]")).click();
    driver().switchTo().alert().dismiss();
    WebElement cMessageDismiss = $(By.id("confirm-demo"));
    $(cMessageDismiss).should(Condition.exactText("You pressed Cancel!"));
  }

  @Test
  public void playWithAlerts3() {

    // click on prompt box
    $(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
    driver().switchTo().alert().dismiss();

    WebElement text1 = $(By.id("prompt-demo"));
    $(text1).should(Condition.empty);

    $(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
    driver().switchTo().alert().sendKeys("Veres László");
    driver().switchTo().alert().accept();
    WebElement text = $(By.id("prompt-demo"));
    $(text).should(Condition.exactText("You have entered 'Veres László' !"));
  }
}
