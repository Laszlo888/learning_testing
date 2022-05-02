import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class WebScraper {

  @BeforeAll
  static void setup() {
    WebDriverManager.firefoxdriver().setup();
  }

  // Open the following website using the WebDriver instance:
  // https://test-automation-demo.greenfox.academy/
  // Verify that the page has loaded successfully by checking the title and URL.
  @Test
  public void verifyPageDisplayed() {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://test-automation-demo.greenfox.academy/");
    driver.manage().window().maximize();
    // verify page loaded successfully by checking title and url
    assertThat(driver.getTitle()).as("Should be empty string").isEqualTo("");
    assertThat(driver.getCurrentUrl()).isEqualTo("https://test-automation-demo.greenfox.academy/");
    driver.quit();
  }

  //  Find the elements with the following id in a single test and fail if they are not found:
  //  menu-button
  //  redirect-link
  //
  //  Also find elements with the following class names:
  //  active
  //  intro
  //
  //  Verify if they are displayed and print their text content to the console.

  @Test
  public void findingElements() {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://test-automation-demo.greenfox.academy/");
    driver.manage().window().maximize();
    // finding menubutton by id
    WebElement menuB = driver.findElement(By.id("menu-button"));
    boolean menuButton = menuB.isDisplayed();
    if (menuButton) {
      System.out.println("Menu button text: " + menuB.getText());
    }
    assertThat(menuButton).as("Menu button should be displayed").isTrue();
    // finding link by id
    WebElement relL = driver.findElement(By.id("redirect-link"));
    boolean rl = relL.isDisplayed();
    if (rl) {
      System.out.println("Link text: " + relL.getText());
    }
    assertThat(rl).as("Link should be displayed").isTrue();
    // finding element by class
    WebElement act = driver.findElement(By.className("active"));
    boolean active = act.isDisplayed();
    if (active) {
      System.out.println("Text: " + act.getText());
    }
    assertThat(active).as("Class 'active' should be displayed").isTrue();
    // finding element by class
    WebElement intro = driver.findElement(By.className("intro"));
    boolean cInt = intro.isDisplayed();
    if (cInt) {
      System.out.println("Text: " + intro.getText());
    }
    assertThat(cInt).as("Class 'intro' should be displayed").isTrue();

    driver.quit();
  }

  //  Create a separate test case for the following test.
  //  There are several links on the website, find the ones which

  //  has the text "Home"
  //  has the text "Blog"
  //
  //  Navigate the the blog by clicking on the "Blog" link, and check if the blog posts are loaded
  // successfully.
  //  Use the Chrome Developer Tools to find out how to locate blog posts to check if they are
  // displayed.

  @Test
  public void findingLinksAndNavigating() {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://test-automation-demo.greenfox.academy/");
    driver.manage().window().maximize();
    WebElement home = driver.findElement(By.partialLinkText("Home"));
    assertThat(home.isDisplayed()).as("Home link should be displayed").isTrue();
    WebElement blog = driver.findElement(By.partialLinkText("Blog"));
    blog.click();
    assertThat(driver.findElement(By.id("blog-section")).isDisplayed())
        .as("Blog section should be displayed")
        .isTrue();
    driver.quit();
  }

  //  Create a separate test case for the following test.
  //  Find the best way to extract the following information for the website and print the results
  // to the console:
  //
  //  Number of images on the Home page
  //  Number of links
  //  Number of blog posts

  //  Navigate to each blog post and read the contents of the post, then save it to a file following
  // the format:
  //  The name of the file is the title of the blog post + .txt
  //  The content of the file is the blog post
  //  Try to save only the blog post, and nothing else from the website

  @Test
  public void extractingInformations() throws IOException {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://test-automation-demo.greenfox.academy/");
    driver.manage().window().maximize();

    // Number of images on page
    // list will be fill with all img tag from site. findelements function gives back all possible
    // matches
    List<WebElement> listImages = driver.findElements(By.tagName("img"));
    int numberOfImages = listImages.size();
    System.out.println("Number of images on page: " + numberOfImages);

    // Number of links on page
    List<WebElement> listLinks = driver.findElements(By.tagName("a"));
    int numberOfLinks = listLinks.size();
    System.out.println("Number of links o page: " + numberOfLinks);

    // Number of blog article
    WebElement blog = driver.findElement(By.partialLinkText("Blog"));
    if (blog.isDisplayed()) {
      blog.click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      List<WebElement> listBlogs = driver.findElements(By.className("blog-article"));
      int numberOfBlogs = listBlogs.size();
      System.out.println("Number of blog article on page: " + numberOfBlogs);
    }

    // blog content writing to file, file named with post title

    // counting posts (I need size for iteration)
    List<WebElement> listBlogContinueRead =
        driver.findElements(By.xpath("//a[contains(text(),'Continue reading')]"));

    // create directory for blog files
    Path path = Paths.get("savedBlogs");
    try {
      Files.createDirectories(path);
    } catch (IOException e) {
      System.err.println("Failed to create directory!" + e.getMessage());
    }

    // iterating through blogs
    for (int i = 0; i < listBlogContinueRead.size(); i++) {

      // I must list posts again because I'm using navigate back and the upper one list is not
      // 'alive' now
      List<WebElement> listBlogContinueReadAgain =
          driver.findElements(By.xpath("//a[contains(text(),'Continue reading')]"));

      // open blog article
      listBlogContinueReadAgain.get(i).click();
      driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

      // filename will be the blog title
      String fileNameWillBe = driver.findElement(By.tagName("h2")).getText() + ".txt";
      File newBlog = new File(path + "/" + fileNameWillBe);
      newBlog.createNewFile();

      // article contains paragraphs, iterate through and write them into txt files
      List<WebElement> articleContent = driver.findElements(By.xpath("//article/p"));
      for (int j = 0; j < articleContent.size(); j++) {
        Files.write(
            Paths.get("savedBlogs/" + fileNameWillBe),
            Collections.singleton(articleContent.get(j).getText()),
            StandardOpenOption.APPEND);
      }
      driver.get("https://test-automation-demo.greenfox.academy/blog");
    }
    driver.quit();
  }
}
