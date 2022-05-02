package pageTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopNavigationTest extends BaseTest {

  @Test
  public void blogMenuIsDisplayed() {
    topNavigation.open();
    Assertions.assertTrue(topNavigation.getBlog().isDisplayed());
  }

  @Test
  public void firstBlogDisplayed() {
    topNavigation.open();
    blogPage = topNavigation.goToBlog();
    Assertions.assertTrue(blogPage.getFirstBlog().isDisplayed());
  }
}
