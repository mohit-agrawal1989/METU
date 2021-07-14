package web.automation.tests;

import org.testng.annotations.*;
import web.automation.utilities.Hooks;

public class SignUpPageTests extends Hooks {

    @Test()
    public void verifyFormErrorMessage1() {
        homePage.enterUsername();
        homePage.enterEmail();
    }

    @Test()
    public void check2(){
        homePage.radioTest();
    }
}
