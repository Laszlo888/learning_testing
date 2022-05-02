import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Pagination {

  // Navigate to the page https://computer-database.gatling.io/computers
  // Enter 'ac' to the search field and click on the filter button
  // wait until the number of search results changed
  // paginate through all the results via clicking on the Next button repeatedly
  // wait and verify after each click that the content of the page really changed

  @Test
  public void loadTillContentExist() {

    Configuration.startMaximized = true;
    Selenide.open("https://computer-database.gatling.io/computers");

    //save pageCounter's text
    String everything = $(By.xpath("//div[@id='pagination']/ul/li[@class='current']/a")).getText();
    $(By.id("searchbox")).sendKeys("ac");
    $(By.id("searchsubmit")).click();

    // after search pageCounter should have different text
    $(By.xpath("//div[@id='pagination']/ul/li[@class='current']/a"))
        .shouldNotHave(text(everything), Duration.ofSeconds(5));

    // pagination, checking a text to change when we are on next page
    String temp;
    do {
      if ($(By.xpath("//li[@class='next']")).isDisplayed()) {
        temp = $(By.xpath("//div[@id='pagination']/ul/li[@class='current']/a")).getText();
        $(By.partialLinkText("Next")).click();

        $(By.xpath("//div[@id='pagination']/ul/li[@class='current']/a")).shouldNotHave(text(temp));
      }
    } while ($$(By.xpath("//li[@class='next']")).size() == 1);
  }
}
