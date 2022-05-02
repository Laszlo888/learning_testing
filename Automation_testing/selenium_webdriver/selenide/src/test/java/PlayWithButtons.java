import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class PlayWithButtons {

  // Part 1:
  //
  // navigate to the page: https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html
  // click on all four buttons in sequence
  // at the end verify that the "All Buttons Clicked" text appears
  //
  // Part 2:
  //
  // navigate to the page: https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
  // click on all four buttons in order
  // at the end verify that the "All Buttons Clicked" text appears
  //
  // Use appropriate waits in both cases

  @Test
  public void playingWithButtons() {

    Configuration.startMaximized = true;
    Selenide.open("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");

    // dynamic buttons
    $(By.id("button00")).click();
    $(By.id("button01")).should(Condition.appear, Duration.ofSeconds(5)).click();
    $(By.id("button02")).should(Condition.appear, Duration.ofSeconds(10)).click();
    $(By.id("button03")).should(Condition.appear, Duration.ofSeconds(10)).click();
    $(By.id("buttonmessage"))
        .should(Condition.exactText("All Buttons Clicked"));

    // disabled dynamic buttons

    Selenide.open("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

    $(By.id("button00")).click();
    $(By.id("button01")).should(Condition.enabled, Duration.ofSeconds(5)).click();
    $(By.id("button02")).should(Condition.enabled, Duration.ofSeconds(10)).click();
    $(By.id("button03")).should(Condition.enabled, Duration.ofSeconds(15)).click();
    $(By.id("buttonmessage"))
        .should(Condition.exactText("All Buttons Clicked"));
  }
}
