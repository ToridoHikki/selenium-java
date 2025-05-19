package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.DropdownPage;
import utils.Browser;

import java.time.Duration;

import static utils.Browser.openBrowser;
import static utils.Browser.visit;

public class DropdownTest {


    @BeforeMethod
    void setup() {
        openBrowser("chrome");
    }

    @Test
    void tc03 () {
//        TC03: DropDown : Select option
//        Open browser
//        Navigate to https://the-internet.herokuapp.com/dropdown
//        Select "option 1"
//        Validate "option 1" is selected

        visit("https://the-internet.herokuapp.com/dropdown");
        Browser.getDriver().findElement(By.id("dropdown")).click();
        Browser.getDriver().findElement(By.cssSelector("option[value='1']")).click();

        Assert.assertTrue(Browser.getDriver().findElement(By.cssSelector("option[selected=selected]")).isDisplayed());

        Browser.getDriver().quit();

    }

    @Test
    void verifyDropdownWorking() throws InterruptedException {
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.open();

        dropdownPage.selectOption("Option 1");
        Assert.assertTrue(dropdownPage.isOptionDisplay("Option 1"));

        dropdownPage.selectOptionByValue("1");
        Assert.assertTrue(dropdownPage.isOptionDisplayByValue("1"));
    }

    @Test
    void ableToSelectMultipleOption () throws InterruptedException {
        Browser.getDriver().get("https://output.jsbin.com/osebed/2");
    }

    @Test
    void verifyTextFieldDisabled() throws InterruptedException {
        Browser.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10));

        Assert.assertFalse(Browser.getDriver().findElement(By.cssSelector("form#input-example input")).isEnabled());

        Browser.getDriver().findElement(By.cssSelector("form#input-example button")).click();

        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form#input-example input"))).isEnabled());
    }

    @Test
    void  verifyLoginSuccessWithValidCredentials() throws InterruptedException {
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String welcomeText = Browser.getDriver().findElement(By.cssSelector("div.example h3")).getText();

        System.out.println(welcomeText);
    }

    @AfterMethod
    void teardown() {
        Browser.quit();
    }



}
