import io.qameta.allure.Muted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutor extends BaseTest {

  @BeforeEach
  @Muted
  void setup() {

    driver.get("http://demo.guru99.com/V4/");
    driver.manage().window().maximize();
  }

  @Test
  @Muted
  public void switchToIframeAndPlayWithJavascriptExecutor() throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.location = 'http://demo.guru99.com/");
    Thread.sleep(4000);
    WebElement email = driver.findElement(By.xpath("//input[@type='text']"));
    js.executeScript("arguments[0].value='sdf@ghj.hu';", email);
    Thread.sleep(3000);
  }
}
