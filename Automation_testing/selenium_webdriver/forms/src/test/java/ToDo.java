import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ToDo {

  // Go to this page: https://lambdatest.github.io/sample-todo-app/
  //
  // add a new item to the list
  // assert it is on the list
  // check the third item
  // assert it is selected
  // check the last item
  // assert that 2 of 6 are selected
  // assert the background color of the add button
  // assert the text of the add button

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @Test
  public void toDo() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://lambdatest.github.io/sample-todo-app/");
    driver.manage().window().maximize();

    // add new item
    driver.findElement(By.id("sampletodotext")).sendKeys("Sixth Item");
    driver.findElement(By.id("addbutton")).click();
    WebElement addedElem = driver.findElement(By.xpath("//span[contains(text(),'Sixth Item')]"));
    assertThat(addedElem.isDisplayed()).as("Should be a span tag with 'Sixth Item' text.").isTrue();

    // check third item
    WebElement checkbox = driver.findElement(By.xpath("//ul/li[3]/input"));
    checkbox.click();
    assertThat(checkbox.isSelected()).as("Third Item should be checked.").isTrue();

    // searching last item in list
    driver.findElement(By.xpath("//ul/li[last()]/input")).click();

    // counting how many checkbox are selected
    List<WebElement> liS = driver.findElements(By.tagName("li"));
    int selectedCounter = 0;
    for (int i = 1; i < liS.size()+1; i++) {
      if (driver.findElement(By.xpath("//ul/li[" + i + "]/input")).isSelected()) {
        selectedCounter++;
      }
    }
    assertThat(selectedCounter).as("Should be 2 selected checkbox.").isEqualTo(2);

    // background color and value of add button
    WebElement addButton = driver.findElement(By.id("addbutton"));
    //  #337ab7  rgba(51, 122, 183, 1)
    assertThat(addButton.getCssValue("background-color"))
        .as("Background color should be: rgba(51, 122, 183, 1)")
        .isEqualTo("rgba(51, 122, 183, 1)");
    assertThat(addButton.getAttribute("value")).as("Button value should be: add").isEqualTo("add");

    driver.quit();
  }
}
