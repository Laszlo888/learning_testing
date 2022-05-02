import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoadMoreResults {

  // Navigate to the page https://webscraper.io/test-sites/e-commerce/more/computers/laptops
  // Click on the More button under the products
  // wait until the number of loaded products changed then click on the More button again
  // repeat the above step until there are more products to display
  //
  // Navigate again to the page https://webscraper.io/test-sites/e-commerce/more/computers/laptops
  // Click repeatedly on the More button this time only until a Dell Inspiron 15 laptop appears
  // among the results
  // once it's there, click on it's name and wait and verify that you are redirected to it's product
  // page

  @BeforeEach
  void setup() {
    Configuration.startMaximized = true;
    Selenide.open("https://webscraper.io/test-sites/e-commerce/more/computers/laptops");
  }

  @Test
  public void loadTillContentExist() {
    do {
      $(By.linkText("More")).click();
    } while (!$(By.linkText("More")).isDisplayed());
  }

  @Test
  public void searchingDellInspiron15AndClickIt() {
    // searching with findElements doesn't throw NoSuchElementException, it gives a zero size list
    if ($$(By.partialLinkText("Dell Inspiron 15")).size() > 0) {
      $(By.partialLinkText("Dell Inspiron 15")).click();
    } else {
      do {
        $(By.linkText("More")).click();
      } while ($$(By.partialLinkText("Dell Inspiron 15")).size() == 0);
      $(By.partialLinkText("Dell Inspiron 15")).click();
    }
    // wait for load product page
    $(By.id("layout-footer")).should(Condition.appear, Duration.ofSeconds(5));
    String url = WebDriverRunner.getWebDriver().getCurrentUrl();

    Assertions.assertTrue(url.contains("product"));
  }
}
