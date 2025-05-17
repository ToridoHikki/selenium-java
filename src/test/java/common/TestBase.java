package common;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import static utils.Browser.captureScreenshot;

public class TestBase {
    @AfterMethod (alwaysRun = true)
    protected void takeScreenShotWhenFail(ITestResult testResult) {
        if(!testResult.isSuccess()) {
            captureScreenshot(testResult.getName());
        }
    }


}
