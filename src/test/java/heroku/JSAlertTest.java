package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertTest {
    @Test
    void verifyClickJSAlert(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You successfully clicked an alert"));

        driver.quit();
    }

    @Test
    void verifyJSConfirmWithDismiss(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().dismiss();

        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You clicked: Cancel"));

        driver.quit();
    }

    @Test
    void verifyJSConfirmWithOK(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You clicked: Ok"));

        driver.quit();
    }

    @Test
    void verifyJSPrompt(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();

        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You entered: Hello World"));

        driver.quit();
    }
}
