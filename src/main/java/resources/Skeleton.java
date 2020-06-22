package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Skeleton {
    public WebDriver driver;
    public Properties properties;
    public String fileLocation = "//Users//arthurbabenko//Documents//Testing//";

    public WebDriver seleniumDriver () throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(fileLocation+"Java//Bestseller//" +
                "src//main//java//resources//data.properties");
        properties.load(fis);

         String browserType = properties.getProperty("browser"); //uncomment to work from IDEA

       // String browserType = System.getProperty("browser");
        // this is work for maven command mvn test -Dbrowser="name browser"

        if (browserType.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", fileLocation+
                    "selenium-java-3//webDriver//chrome//chromedriver");
            ChromeOptions option = new ChromeOptions();
            if (browserType.contains("headless")) option.addArguments("--headless");
            driver = new ChromeDriver(option);

        }

        else if (browserType.equals("safari")) {
            System.setProperty("webdriver.safari.driver", "//usr//bin//safaridriver");
             driver = new SafariDriver();
        }
        else if (browserType.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", fileLocation+
                    "selenium-java-3//webDriver//firefox//geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // global waiting for loading

        return driver;

    }

    public String ScreenShot(String testCaseName, WebDriver driver) throws IOException {

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String info = cap.getPlatform().toString()+" "+
                cap.getBrowserName().toLowerCase()+" " +cap.getVersion().toString();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File path = ts.getScreenshotAs(OutputType.FILE);
        String destinationFolder = System.getProperty("user.dir")+"//reports//screenshot//"+
                info+" "+testCaseName+".png";
        FileUtils.copyFile(path, new File(destinationFolder));
        return destinationFolder;
    }

}
