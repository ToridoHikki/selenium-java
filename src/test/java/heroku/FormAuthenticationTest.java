package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    void tc01 () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

//        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith!");
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area. When you are done click logout below."));
//        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(), "Welcome to the Secure Area. When you are done click logout below.");

        driver.quit();










    }
}
