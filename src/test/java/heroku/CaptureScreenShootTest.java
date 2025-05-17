package heroku;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Browser;

import java.io.File;
import java.io.IOException;

import static utils.Browser.openBrowser;
import static utils.Browser.visit;

public class CaptureScreenShootTest {
    @Test
    void captureScreenShot(){
        openBrowser("chrome");
        visit("https://the-internet.herokuapp.com/context_menu");

        TakesScreenshot takesScreenshot = (TakesScreenshot) Browser.getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", "context-menu", System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
