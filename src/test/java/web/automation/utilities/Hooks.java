package web.automation.utilities;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import web.automation.pages.HomePage;

import java.util.Objects;

public class Hooks extends BrowserConfiguration {

    public HomePage homePage;
    PropertyReader reader = new PropertyReader();

    @BeforeMethod
    @Parameters({"browser"})
    protected void openApp(@Optional("chrome") String browser) {
        String url = reader.readProperty("appUrl", "testInfo.properties");
        BrowserConfiguration.openBrowser(browser);
        if(url.contains("stage")){
            Objects.requireNonNull(getWebDriver()).navigate().to(reader.readProperty("stage", "testInfo.properties"));
        }
        else if (url.contains("prod")){
            Objects.requireNonNull(getWebDriver()).navigate().to(reader.readProperty("prod", "testInfo.properties"));
        }
        else if (url.contains("qa")){
            Objects.requireNonNull(getWebDriver()).navigate().to(reader.readProperty("qa", "testInfo.properties"));
        }
        else
            Objects.requireNonNull(getWebDriver()).navigate().to(reader.readProperty("qa", "testInfo.properties"));

        addAllPageObjects();
    }

    @AfterMethod
    protected void closeDriver() {
        Objects.requireNonNull(getWebDriver()).quit();
    }

    public void addAllPageObjects(){
        homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
    }
}
