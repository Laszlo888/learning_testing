import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class Screenshot extends BaseTest {

  @BeforeEach
  void setup() {
    driver.get("https://www.eurohandball.com/");
    driver.manage().window().maximize();
  }

  @Test
  public void takeScreenshot() throws IOException {

    WebElement footer = driver.findElement(By.tagName("footer"));
    assertThat(footer.isDisplayed()).isTrue();

    // add date to filename
    Date currentDate = new Date();
    String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");

    // take screenshot
    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshotFile, new File("ehf_saved_" + screenshotFileName + ".png"));
  }
}
