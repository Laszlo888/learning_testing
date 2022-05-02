import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponsiveTesting {

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.get("https://lambdatest.github.io/docs/real-time-browser-testing");
  }

  @Test
  @DisplayName("Right sided links moves under a menu from 1024px")
  public void rightSidedLInksNotDisplayedUnder1024px() {
    driver.manage().window().setSize(new Dimension(1024, 580));
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    List<WebElement> rightSideLink = driver.findElements(By.linkText("How to launch a VM?"));
    assertThat(rightSideLink.size()).isEqualTo(0);
  }

  @Test
  @DisplayName("Right sided links moves under a menu from 1024px")
  public void rightSidedLInksDisplayedFrom1024px() {
    driver.manage().window().setSize(new Dimension(1038, 580));
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    List<WebElement> rightSideLink = driver.findElements(By.linkText("How to launch a VM?"));
    assertThat(rightSideLink.size()).isEqualTo(1);
  }

  @Test
  @DisplayName("Getting Started header disappear around 1024px")
  public void gettingStartedHeaderNotDisplayedUnder1024px() {
    driver.manage().window().setSize(new Dimension(1024, 580));
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    WebElement leftHeader =
        driver.findElement(By.xpath("//h3[contains(text(),'Getting Started')]"));
    assertThat(leftHeader.isDisplayed()).isFalse();
  }

  @Test
  @DisplayName("Lambdatest header disappear from 1036px")
  public void lambdatestHeaderNotDisplayedUnder1036px() throws InterruptedException {
    driver.manage().window().setSize(new Dimension(490, 580));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebElement topHeader = driver.findElement(By.xpath("//h2[contains(text(),'Lambdatest')]"));
    Thread.sleep(3000);
    assertThat(topHeader.isDisplayed()).isFalse();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
