package web.automation.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    PropertyReader reader = new PropertyReader();
    int counter = 0;
    int retryLimit = Integer.parseInt(reader.readProperty("retryLimit","testInfo.properties"));

    @Override
    public boolean retry(ITestResult result) {

        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
