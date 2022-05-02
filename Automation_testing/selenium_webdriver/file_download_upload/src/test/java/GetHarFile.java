import net.lightbody.bmp.core.har.Har;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

public class GetHarFile extends ProxySetup {

    @Test
    public void alertHandling() throws IOException {
        // this is just a label
        proxy.newHar("alert");
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Alert alert = driver.switchTo().alert();

        alert.dismiss();

        // get the HAR data
        Har har = proxy.getHar();
        // write to a file, we get a har file
        har.writeTo(new File("alert.har"));
    }
}
