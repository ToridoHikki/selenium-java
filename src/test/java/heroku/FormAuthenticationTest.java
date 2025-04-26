package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.heroku.FormAuthenticationPage;

import static utils.Browser.getCurrentUrl;
import static utils.Browser.openBrowser;

//import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class FormAuthenticationTest {
    /*
        1.Open browser
        2. Navigate to https://the-internet.herokuapp.com/login
        3. Fill in username with tomsmith
        4. Fill in the password with SuperSecretPassword!
        5. Click on Login button
        6. And the home page is appear
     */

//    @Parameters({"browser"})
    @Test
    void tc01 (String browser) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area. When you are done click logout below."));

        driver.quit();

    }

    @Test
    void pageObject() throws InterruptedException {
        openBrowser("chrome");
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();

        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword!");

        Thread.sleep(2000);
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertEquals(formAuthenticationPage.getWelcomeMessage(), "Welcome to the Secure Area. When you are done click logout below.");
    }
}
