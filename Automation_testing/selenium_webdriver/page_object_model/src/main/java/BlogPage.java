import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {

  WebDriver driver;

  @FindBy(xpath = "//div[@id='blog-section']/div[1]")
  WebElement firstBlog;

  public BlogPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}
