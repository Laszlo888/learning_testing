import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

// Create a function called findByLabelText() which expects
// a WebDriver instance as the first input parameter, and a string representing a label text.
// Return a WebElement of an input field which has the matching label text.
// Throws NoSuchElementException if a matching input field was not found.

public class FindInputByLabelText {

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    WebElement findInputByLabel(WebDriver driver, String labelText) {
        WebElement findedInput = driver.findElement(By.xpath("//input[@id='" + labelText + "']"));
        if (findedInput.isDisplayed() || findedInput.isEnabled()) {
            return findedInput;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Test
    public void tryFindInputByLabelFunction(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://tturak.hu/turanaptar");
        driver.manage().window().maximize();
        findInputByLabel(driver,"param1");
        driver.quit();
    }
}
