import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class MixingItUp {

  // An exercise to demonstrate what happens when implicit and explicit wait is mixed
  //
  // Create a test class with where in the before method you navigate to any page of your choice,
  // set an implicit wait of 15 seconds then log the current time (with at least an accuracy of
  // seconds) to the console (to know when your next step starts).
  // Create and after method as well, where you log the end time of your test to check the elapsed
  // time, then quit the driver
  // Then create a test where the only thing you do is try to find a not existing element on the
  // opened page
  // Run the test and check if the elapsed time really was ~15 seconds
  // Now add a webdriverwait with a 20 seconds timeout to your nonexistent element (while keeping
  // the implicit wait as well).
  // Run the test again and check the elapsed time. Was it what you expected?
  // Now delete your implicit wait and run the test again. Check if elapsed time really was ~20
  // seconds

    // result: implicit and explicit wait separately working well, together waiting time is 31 seconds

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://tturak.hu/");
    driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime most = LocalDateTime.now();
    System.out.println(dtf.format(most));
  }

  @Test
  public void testImplicitAndExplicitWaitTogether() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("not_exist")));
  }

  @AfterEach
  void tearDown() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime most = LocalDateTime.now();
    System.out.println(dtf.format(most));
    driver.quit();
  }
}
