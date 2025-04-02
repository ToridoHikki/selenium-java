package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropdownTest {

    @Test
    void tc03 () {
//        TC03: DropDown : Select option
//        Open browser
//        Navigate to https://the-internet.herokuapp.com/dropdown
//        Select "option 1"
//        Validate "option 1" is selected

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
//        Assert.assertTrue(driver.findElement((By.cssSelector("option[selected=selected]"))).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector("option[selected=selected]")).isDisplayed());

        driver.quit();

    }

    @Test
    void verifyDropdownWorking() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByContainsVisibleText("Option 1");
        Assert.assertTrue(driver.findElement(By.xpath("//optiion[.='Option 1']")).isDisplayed());

        select.selectByValue("1");
        Assert.assertTrue(driver.findElement(By.cssSelector("option[value='1']")).isDisplayed());

        select.selectByIndex(1);
        Assert.assertTrue(driver.findElement(By.xpath("//select/option[1]")).isDisplayed());
    }

    @Test
    void ableToSelectMultipleOption () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
    }

    @Test
    void verifyTextfieldDisabled () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertFalse(driver.findElement(By.cssSelector("form#input-example input")).isEnabled());

        driver.findElement(By.cssSelector("from#input-example button")).click();

        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form#input-example input"))).isEnabled());


        driver.quit();
    }

    @Test
    void  verifyLoginSuccessWithValidCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String welcomeText = driver.findElement(By.cssSelector("div.example h3")).getText();

        System.out.println(welcomeText);

        //prinrt welcome text






    }



}
