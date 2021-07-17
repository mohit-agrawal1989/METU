package web.automation.tests;

import org.testng.annotations.Test;
import web.automation.utilities.Hooks;

public class CheckboxTest extends Hooks {

    @Test()
    public void verifyFormErrorMessage2() {
        homePage.verifyCheckbox();
    }
}
