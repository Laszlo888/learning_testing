package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TopNavigation {

  public WebElement getHome() {
    return $(By.linkText("Home"));
  }

  public WebElement getShop() {
    return $(By.linkText("Shop"));
  }

  public WebElement getBlog() {
    return $(By.linkText("Blog"));
  }

  public WebElement getAbout() {
    return $(By.linkText("About"));
  }

  public void open() {
    Configuration.startMaximized = true;
    Selenide.open("https://test-automation-demo.greenfox.academy/");
  }

  public BlogPage goToBlog() {
    getBlog().click();
    return new BlogPage();
  }
}
