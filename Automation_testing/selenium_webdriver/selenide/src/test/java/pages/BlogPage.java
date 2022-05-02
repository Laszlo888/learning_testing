package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class BlogPage {

  public WebElement getFirstBlog() {
    return $(By.xpath("//div[@id='blog-section']/div[1]"));
  }
}
