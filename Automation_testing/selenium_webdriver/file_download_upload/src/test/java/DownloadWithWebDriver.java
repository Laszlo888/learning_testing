import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Create a new test class and create a new Selenium WebDriver test.
//
// Navigate to the following website: http://the-internet.herokuapp.com/download
// Locate every link which points to a downloadable file
// Read the href attributes of the links to collect the file URLs
// Download every file using REST Assured
// Validate that the files downloaded correctly
// Check that the status code is 200 OK
// Find a way to validate the file content in each case


public class DownloadWithWebDriver {

  WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("http://the-internet.herokuapp.com/download");
    driver.manage().window().maximize();
  }

  @Test
  public void fileDownloadWithWebDriverAndRestAssured() {

    List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));

    for (int i = 0; i < links.size(); i++) {
      String hReF = links.get(i).getAttribute("href");

      byte[] responseFile =
          RestAssured.given()
              .when()
              .get(hReF)
              .then()
              .assertThat()
              .statusCode(200)
              .and()
              .extract()
              .asByteArray();

      // write content to file
      try {
        Files.write(Paths.get("downloadedFiles/" + links.get(i).getText()), responseFile);
      } catch (IOException e) {
        System.out.println("File writing failed.");
      }



    }
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
