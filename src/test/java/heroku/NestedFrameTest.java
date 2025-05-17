package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browser;

import static utils.Browser.openBrowser;
import static utils.Browser.visit;

public class NestedFrameTest {

    @Test
    void verifyNestedFrame () throws InterruptedException {

        openBrowser("chrome");
        visit("https://the-internet.herokuapp.com/nested_frames");

        Browser.getDriver().switchTo().frame(0);
        Browser.getDriver().switchTo().frame(0);
        Assert.assertTrue(Browser.getDriver().findElement(By.tagName("body")).getText().contains("LEFT"));

        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().frame(1);
        Assert.assertTrue(Browser.getDriver().findElement(By.tagName("body")).getText().contains("MIDDLE"));

        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().frame("frame-right");
        Assert.assertTrue(Browser.getDriver().findElement(By.tagName("body")).getText().contains("RIGHT"));

        Browser.getDriver().switchTo().defaultContent();
        Browser.getDriver().switchTo().frame("frame-bottom");
        Assert.assertTrue(Browser.getDriver().findElement(By.tagName("body")).getText().contains("BOTTOM"));

    }
}
