import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigation {

  WebDriver driver;

  @FindBy(linkText = "Home")
  WebElement home;

  @FindBy(linkText = "Shop")
  WebElement shop;

  @FindBy(linkText = "Blog")
  WebElement blog;

  @FindBy(linkText = "About")
  WebElement about;

  public TopNavigation(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("https://test-automation-demo.greenfox.academy/");
    driver.manage().window().maximize();
  }

  public BlogPage goToBlog() {
    blog.click();
    return new BlogPage(driver);
  }
}
