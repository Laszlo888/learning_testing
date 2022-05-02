import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class AjaxCall2 {

  // go back to your Ajax call exercise and after your first click and wait click on the button
  // again and wait and verify that a second success message shows up as well.
  //
  // Refactor your code so that the verification would work with any number of repeated
  // clicks/messages

  @ParameterizedTest
  @ValueSource(ints = {4})
  public void clickingAjaxMoreTimes(int clickNumber) {

    Configuration.startMaximized = true;
    Selenide.open("http://uitestingplayground.com/ajax");

    for (int i = 1; i < clickNumber + 1; i++) {
      $(By.id("ajaxButton")).click();
      $(By.xpath("//div[@id='content']/p[" + i + "]"))
          .should(Condition.appear, Duration.ofSeconds(25));
    }
  }
}
