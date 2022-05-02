import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

// Navigate to this page: http://demo.guru99.com/test/delete_customer.php
// Fill out the Customer ID
// Click on the Submit button
// Capture the alert message
// Print the alert message
// Close the alert popup

public class HandleAlert extends BaseTest{

  @BeforeEach
  void setup() {

    driver.get("http://demo.guru99.com/test/delete_customer.php");
    driver.manage().window().maximize();
  }

  @Test
  public void getAlertMessageAndCloseIt() {

    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("123456");
    driver.findElement(By.xpath("//input[@type='submit']")).click();

    Alert alert = driver.switchTo().alert();
    String message = alert.getText();

    System.out.println();
    System.out.println(message);
    System.out.println();

    alert.dismiss();
  }
}
