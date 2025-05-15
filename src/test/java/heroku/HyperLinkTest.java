package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.mouse.HyperLinkPage;

import java.time.Duration;

import static utils.Browser.*;

public class HyperLinkTest {

    @Test
    void verifyLinkGoToCorrectScreen() {

//        Open browser
//        Navigate to https://the-internet.herokuapp.com/status_codes
//        Click on "200"
//        Then "200 status code" page appear
//        Click on "go here"
//        Click on "301"
//        Then "301 status code" page appear
//        Click on "go here"
//        Click on "404"
//        Then "404 status code" page appear
//        Click on "go here"
//        Click on "500"
//        Then "500 status code" page appear
//        Click on "go here"

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 200 status code"));
        driver.findElement(By.linkText("here")).click();


        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 301 status code"));
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        Assert.assertTrue(content.contains("This page returned a 304 status code"));
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        Assert.assertTrue(content.contains("This page returned a 500 status code"));
        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes");


        driver.quit();

    }

    @Test
    void verifyLinkGoToCorrectScreenWithPageObject() {
        openBrowser("chrome");
        HyperLinkPage hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.open();

        hyperLinkPage.clickLinkText("here");
        hyperLinkPage.clickLinkText("200");
        Assert.assertTrue(hyperLinkPage.isPageLoaded("200"), "This page returned a 200 status code.");
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        hyperLinkPage.clickLinkText("here");
    }


    @AfterMethod
    void tearDown() {
        quit();

    }
}
