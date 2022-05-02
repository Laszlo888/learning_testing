import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

// Navigate to the page: http://uitestingplayground.com/ajax
// Click on the button on the page and wait until the "Data loaded with AJAX get request." message
// appears

public class AjaxCall {

  @Test
  public void verifyAjaxCall() {

    // browser start with max. size
    Configuration.startMaximized = true;
    // selenide using chrome default with browsers size 1366x768
    Selenide.open("http://uitestingplayground.com/ajax");
    // search button and click it
    $(By.id("ajaxButton")).click();
    // wait for element appear till max. 25 sec
    $(By.xpath("//p[@class='bg-success']")).should(Condition.appear, Duration.ofSeconds(25));
  }
}
