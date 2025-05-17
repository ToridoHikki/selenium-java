package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mouse.HyperLinkPage;

import java.time.Duration;

import static utils.Browser.*;

public class HyperLinkTest {

    HyperLinkPage hyperLinkPage = new HyperLinkPage();

    @BeforeMethod
    void setUp() {
        openBrowser("chrome");
        hyperLinkPage.open();
    }


    @Test
    void verify200LinkGoToCorrectScreen() {

        hyperLinkPage.clickLinkText("200");
        Assert.assertTrue(hyperLinkPage.isPageLoaded("200"), "This page returned a 200 status code.");
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        hyperLinkPage.clickLinkText("here");
    }

    @Test
    void verify301LinkGoToCorrectScreen() {
        hyperLinkPage.clickLinkText("301");
        Assert.assertTrue(hyperLinkPage.isPageLoaded("301"), "This page returned a 301 status code.");
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        hyperLinkPage.clickLinkText("here");
    }

    @Test
    void verify404LinkGoToCorrectScreen() {
        hyperLinkPage.clickLinkText("404");
        Assert.assertTrue(hyperLinkPage.isPageLoaded("301"), "This page returned a 404 status code.");
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        hyperLinkPage.clickLinkText("here");
    }

    @Test
    void verify500LinkGoToCorrectScreen() {
        hyperLinkPage.clickLinkText("500");
        Assert.assertTrue(hyperLinkPage.isPageLoaded("500"), "This page returned a 500 status code.");
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        hyperLinkPage.clickLinkText("here");
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes");
    }


    @AfterMethod
    void tearDown() {
        quit();

    }
}
