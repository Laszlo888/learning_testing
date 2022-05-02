import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import net.lightbody.bmp.proxy.auth.AuthType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

//    Set up BrowserMob Proxy by following the upcoming steps.
//    Add the following dependencies:
//    testImplementation 'net.lightbody.bmp:browsermob-core:2.1.5'
//
//    Before creating the WebDriver, create a new instance of the proxy:
//    start the proxy:
//    BrowserMobProxy proxy = new BrowserMobProxyServer();
//    proxy.start(0);
//
//    enable more detailed HAR capture, if desired (see CaptureType for the complete list):
//    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//
//    Use the proxy when you create the WebDriver:
//
//    get the Selenium proxy object:
//    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//    ChromeOptions chromeOptions = new ChromeOptions();
//    chromeOptions.setCapability(CapabilityType.PROXY, seleniumProxy);
//
//    org.openqa.selenium.WebDriver driver = new ChromeDriver(chromeOptions);
//
//    Go to one of your previous tests and capture the network traffic:
//    create a new HAR with the label "test1"
//    proxy.newHar("test1");
//
//    open the site and run the test code:
//    driver.get("...");
//    ...
//
//    get the HAR data:
//    Har har = proxy.getHar();
//
//   write to a file:
//   har.writeTo(new File("test1.har"));
//
//   Write the Har content to a file:
//
//   Run the test, then check the file using a HAR Reader.
//
//   If you get the following error:
//
//
// Bootstrap.channelFactory(Lio/netty/channel/ChannelFactory;)Lio/netty/bootstrap/AbstractBootstrap;
//   java.lang.NoSuchMethodError:
// io.netty.bootstrap.Bootstrap.channelFactory(Lio/netty/channel/ChannelFactory;)Lio/netty/bootstrap/AbstractBootstrap;
//
//   Try adding the following dependency:
//
//   testImplementation group: 'io.netty', name: 'netty-all', version: '4.1.63.Final'
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProxySetup {

  WebDriver driver;
  WebDriverWait wait;
  // proxy supports network traffic monitoring and manipulating
  BrowserMobProxy proxy;

  @BeforeAll
  public void setup() {
    // start the proxy
    proxy = new BrowserMobProxyServer();
    proxy.start(0);
    
    // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

    // Creates a Selenium Proxy object from the BrowserMobProxy instance. The BrowserMobProxy must be started.
    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

    // You can create an instance of ChromeOptions, which has convenient methods for setting ChromeDriver-specific capabilities
    // Since Selenium version 3.6.0, the ChromeOptions class in Java also implements the Capabilities interface,
    // allowing you to specify other WebDriver capabilities not specific to ChromeDriver.
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability(CapabilityType.PROXY, seleniumProxy);

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(chromeOptions);
    wait = new WebDriverWait(driver, 15);
  }

  @AfterAll
  public void tearDown() {
    proxy.stop();
    driver.quit();
  }
}
