package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Browser;

import static utils.Browser.openBrowser;
import static utils.Browser.visit;

public class JSAlertTest {

    @BeforeMethod
    void setUp() {
        openBrowser("chrome");
    }
    @Test
    void verifyClickJSAlert(){
        visit("https://the-internet.herokuapp.com/javascript_alerts");

        Browser.getDriver().findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        String alertText = Browser.getDriver().switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        Browser.getDriver().switchTo().alert().accept();

        String resultText = Browser.getDriver().findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You successfully clicked an alert"));

        Browser.getDriver().quit();
    }

    @Test
    void verifyJSConfirmWithDismiss(){
        visit("https://the-internet.herokuapp.com/javascript_alerts");
        Browser.getDriver().findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        String alertText = Browser.getDriver().switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        Browser.getDriver().switchTo().alert().dismiss();

        String resultText = Browser.getDriver().findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You clicked: Cancel"));

        Browser.getDriver().quit();
    }

    @Test
    void verifyJSConfirmWithOK(){
        visit("https://the-internet.herokuapp.com/javascript_alerts");
        Browser.getDriver().findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        String alertText = Browser.getDriver().switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        Browser.getDriver().switchTo().alert().accept();

        String resultText = Browser.getDriver().findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You clicked: Ok"));

        Browser.getDriver().quit();
    }

    @Test
    void verifyJSPrompt(){
        visit("https://the-internet.herokuapp.com/javascript_alerts");
        Browser.getDriver().findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        String alertText = Browser.getDriver().switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        Browser.getDriver().switchTo().alert().sendKeys("Hello World");
        Browser.getDriver().switchTo().alert().accept();

        String resultText = Browser.getDriver().findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You entered: Hello World"));

        Browser.getDriver().quit();
    }
}
