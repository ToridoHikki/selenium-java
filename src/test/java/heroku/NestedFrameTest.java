package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrameTest {

    @Test
    void verifyNestedFrame () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("LEFT"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("MIDDLE"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("RIGHT"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("BOTTOM"));

    }
}
