import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class WaitForProgress2 {

  // navigate to the page: https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html
  // click on the Start Download button
  // verify that the download modal opened
  // wait until all these conditions are fulfilled:
  // the Complete! text is visible
  // the progress bar reached the end
  // and the Close button appears
  // then close the modal
  // and verify that the modal is not visible anymore

  @Test
  public void usingAndInWaiting() {

    Configuration.startMaximized = true;
    Selenide.open("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");

    $(By.id("downloadButton")).click();

    // download window opened or not
    WebElement downloadWindow = $(By.xpath("//span[contains(text(),'File Download')]"));

    $(downloadWindow).should(Condition.appear, Duration.ofSeconds(5));

    $(By.xpath("//div[@class='progress-label']"))
        .should(Condition.exactText("Complete!"), Duration.ofSeconds(25));
    $(By.id("progressbar")).should(Condition.attribute("aria-valuenow", "100"));
    $(By.xpath("//div[@class='ui-dialog-buttonset']/button")).should(Condition.exactText("Close"));

    // close and verify download window is not there
    $(By.xpath("//div[@class='ui-dialog-buttonset']/button")).click();
    $(downloadWindow).should(Condition.disappear);
  }
}
