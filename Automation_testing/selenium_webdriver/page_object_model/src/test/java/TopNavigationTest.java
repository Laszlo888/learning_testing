import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TopNavigationTest extends BaseTest {

  @Test
  public void blogMenuIsDisplayed() {
    TopNavigation topNav = PageFactory.initElements(driver, TopNavigation.class);
    topNav.open();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Assertions.assertThat(topNav.blog.isDisplayed()).isTrue();
  }

  @Test
  public void firstBlogDisplayed() {
    TopNavigation topNav = PageFactory.initElements(driver, TopNavigation.class);
    topNav.open();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    BlogPage bl = topNav.goToBlog();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Assertions.assertThat(bl.firstBlog.isDisplayed()).isTrue();
  }
}
