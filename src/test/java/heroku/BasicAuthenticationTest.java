package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.Browser;

import static utils.Browser.*;

public class BasicAuthenticationTest {
    @Test
    void verifyLoginSuccessWithValidCredentials(){
        openBrowser("chrome");
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String welcomeMessage = Browser.getDriver().findElement(By.tagName("p")).getText();
        Assert.assertTrue(welcomeMessage.contains("Congratulations! You must have the proper credentials."));
    }

    @AfterMethod
    void teardown(){
        quit();
    }
}
