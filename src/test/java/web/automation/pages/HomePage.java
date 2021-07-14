package web.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.automation.utilities.DriverPage;
import web.automation.utilities.ExecutionLog;

public class HomePage{

    @FindBy(id="userName")
    WebElement username;

    @FindBy(id="userEmail")
    WebElement useremail;

    @FindBy(xpath="(//li[@id='item-1'])[1]")
    WebElement checkbox;

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    WebElement check;

    @FindBy(xpath = "//span[text()='Radio Button']")
    WebElement radio;

    @FindBy(xpath = "//*[@class='custom-control-input']")
    WebElement imp;

    ExecutionLog log = new ExecutionLog();

    public void enterUsername(){
        username.sendKeys("testingName");
        log.log("username entered");
    }

    public void enterEmail(){
        useremail.sendKeys("mohit.testing1@gmail.com");
        log.log("email entered");
    }

    public void verifyCheckbox(){
        checkbox.click();
        check.click();
        Assert.assertTrue(check.isSelected());
        log.log("Checkbox state is verified.");
    }

    public void radioTest(){
        radio.click();
        imp.click();
    }
}
