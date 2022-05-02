import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class WaitForProgress {

  @Test
  public void waitForProgress() {

    // browser start with max. size
    Configuration.startMaximized = true;
    // selenide using chrome default with browsers size 1366x768
    Selenide.open("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
    // search button and click it
    $(By.id("downloadButton")).click();
    // wait for element appear till max. 5 sec
    $(By.xpath("//span[contains(text(),'File Download')]"))
        .should(Condition.appear, Duration.ofSeconds(5));

    $(By.xpath("//button[contains(text(),'Close')]"))
        .should(Condition.appear, Duration.ofSeconds(35))
        .click();

    $(By.xpath("//span[contains(text(),'File Download')]"))
        .should(Condition.disappear, Duration.ofSeconds(3));
  }
}
