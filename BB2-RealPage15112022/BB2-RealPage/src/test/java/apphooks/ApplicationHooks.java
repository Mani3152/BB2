 package apphooks;

 import com.driver.WebdriverIntializer;
 import com.utils.ConfigReader;
 import io.cucumber.java.After;
 import io.cucumber.java.Before;
 import io.cucumber.java.Scenario;
 import org.openqa.selenium.OutputType;
 import org.openqa.selenium.TakesScreenshot;
 import org.openqa.selenium.WebDriver;

 import java.time.Duration;
 import java.util.Properties;

 public class ApplicationHooks {

     private WebdriverIntializer driverFactory;
     private WebDriver driver;
     private ConfigReader configReader;
     Properties prop;

     @Before(order = 0)
     public void getProperty() {
         configReader = new ConfigReader();
         prop = configReader.init_prop();
     }

     @Before(order = 1)
     public void launchBrowser() {
         String browserName = prop.getProperty("browser");
         driverFactory = new WebdriverIntializer();
         driver = driverFactory.init_driver(browserName);
         driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
         driver.get("http://realpage.vassarlabs.com/");

     }


     @After(order = 0)
     public void quitBrowser() {

         driver.quit();
     }

     @After(order = 1)
     public void tearDown(Scenario scenario) {
         if (scenario.isFailed()) {
             // take screenshot:
             String screenshotName = scenario.getName().replaceAll(" ", "_");
             byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
             scenario.attach(sourcePath, "image/png", screenshotName);

         }
     }

 }
