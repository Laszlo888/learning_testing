import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

    // Open your IntelliJ, New Project
    // Choose Gradle form the left hand side list then click Next
    // Give a name of your project
    // Choose a location of your project folder then click Finish
    // Wait a minute until Gradle build your project
    // Drop down your project folder then src folder on the left hand side panel
    // Open build.gradle file and insert into dependencies
    // Refresh Gradle by clicking the elephant icon or on the right hand side Gradle/Reload all gradle project
    // Start with setting up WebDriverManager in your test class (in this case you do not have to use System.setProperty())

public class FirstSel {

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }
    
    // According to the guideline set up your system and write a WebDriver test to open a webpage, maximize the window then close it.
    // Try to run the test from IntelliJ and your terminal as well.
    // Try to find out how the page can be open for 3 seconds before your code closes it.

    @Test
    public void openLetourWithChromeDriver() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letour.fr/en/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();
    }

    // Go to w3schools.com and verify if the page is loaded successfully
    // Go to javatpoint.com and verify if the page is loaded successfully
    // Navigate to the previous page
    // Assert that the title of the page is what you expect
    // Navigate forward
    // Find the searchbar and type in: java tutorial.
    // Close the page

    @Test
    public void navigationPractice() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com");
        Assertions.assertEquals("W3Schools Online Web Tutorials", driver.getTitle());
        // implicit wait
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.navigate().to("https://www.javatpoint.com");
        WebDriverWait wait1 = new WebDriverWait(driver, 7);
        WebElement signIn1 = wait1.until(ExpectedConditions.elementToBeClickable(By.name("search")));
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.navigate().back();
        Assertions.assertEquals("W3Schools Online Web Tutorials", driver.getTitle());
        driver.navigate().forward();
        //explicit wait
        WebDriverWait wait2 = new WebDriverWait(driver, 7);
        WebElement signIn2 = wait2.until(ExpectedConditions.elementToBeClickable(By.name("search")));
        driver.findElement(By.name("search")).sendKeys("java tutorial");
        driver.quit();
    }

    // Create a new testcase
    // Go to: hasbean.co.uk and verify if the page is loaded successfully
    // Search for the keyword brazil
    // Navigate back to main page by using findElement() method
    // Refresh the page
    // Assert that the title of the page is what you expect
    // Close the page

    @Test
    public void INeedCoffee() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hasbean.co.uk");
        driver.manage().window().maximize();
        Assertions.assertEquals("Hasbean: Specialty coffee supply, roasted to order.", driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // searching for search field with xpath relative path
        driver.findElement(By.xpath("//div[@class='header-bar__right post-large--display-table-cell']//div[@class='header-bar__module " +
                "header-bar__search']//form[@class='header-bar__search-form clearfix']//input[@type='search']")).sendKeys("brazil");
        // relative path copied to click search icon
        driver.findElement(By.xpath("//div[@class='header-bar__right post-large--display-table-cell']//div[@class='header-bar__module header-bar__search']//form[@class='header-bar__search-form " +
                "clearfix']//button[@type='submit']//span[@class='icon icon-search']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        // clickable svg finding and there are more with same xpath, we need xpath="2"
        // click on title to go homepage
        driver.findElement(By.xpath("(//*[name()='svg' and @class='logo__image'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        // title assertation
        Assertions.assertEquals("Hasbean: Specialty coffee supply, roasted to order.", driver.getTitle());
        driver.quit();
    }
}
