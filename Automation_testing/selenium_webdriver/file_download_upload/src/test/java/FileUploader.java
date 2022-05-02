import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


// Create a new test class to test the following file uploader: http://the-internet.herokuapp.com/upload
//
// Navigate to the website
// Upload a simple text file
// Validate that the upload was successful


public class FileUploader {

  WebDriver driver;
  WebDriverWait wait;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("http://the-internet.herokuapp.com/upload");
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 20);
  }

  @Test
  public void fileUpload() {

    // choose file to upload
    File testPicture = new File("src/test/resources/upVL.txt");

    // send filepath to choose file button
    driver.findElement(By.id("file-upload")).sendKeys(testPicture.getAbsolutePath());

    // upload file
    driver.findElement(By.id("file-submit")).click();

    // wait for success message
    wait.until(
        ExpectedConditions.presenceOfElementLocated(
            By.xpath("//h3[contains(text(),'File Uploaded!')]")));
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
