import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDrop {

  // Create a test case, and navigate to this page:
  //
  // https://jqueryui.com/resources/demos/droppable/default.html
  //
  // Perform drag & drop in the demo and verify if the background color of the target area changed
  // as expected.

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void checkingBackgroundColorAfterDragAndDrop() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
    driver.manage().window().maximize();

    WebElement draggedItem = driver.findElement(By.id("draggable"));
    WebElement droppableItem = driver.findElement(By.id("droppable"));

    Actions action = new Actions(driver);
    action.dragAndDrop(draggedItem, droppableItem).build().perform();

    //  starting color:  #e9e9e9   rgba(233, 233, 233, 1)
    //  after drag and drop color: #fffa90   rgba(255, 250, 144, 1)
    assertThat(droppableItem.getCssValue("background-color"))
        .as("Changed background color code should be: rgba(255, 250, 144, 1)")
        .isEqualTo("rgba(255, 250, 144, 1)");

    driver.quit();
  }
}
