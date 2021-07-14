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
        BrowserConfiguration.openBrowser(browser);
        Objects.requireNonNull(getWebDriver()).navigate().to(reader.readProperty("appUrl", "testInfo.properties"));
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
