package web.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class BrowserConfiguration {
    private static WebDriver driver;

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getWebDriver() {
        webDriver.set(driver);
        return webDriver.get();
    }

    public static void openBrowser(String browserType) {


        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver_mac");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        else if(browserType.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        else{}

        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
