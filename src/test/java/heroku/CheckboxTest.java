package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckboxTest {

    @Test
    void tc02() throws InterruptedException {
//        TC02: Checkboxes : Check to a box
//        Open browser
//        Navigate to https://the-internet.herokuapp.com/checkboxes
//        Check on checkbox1
//        Verify checkbox1 is checked
//        Check on checkbox2
//        Verify checkbox2 is checked

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.cssSelector("input[type=checkbox]:nth-child(1)"));
        check(checkbox1);
        Assert.assertTrue(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        check(checkbox2);
        Assert.assertTrue(checkbox2.isSelected());

        uncheck(checkbox1);
        Assert.assertFalse(checkbox1.isSelected());

        uncheck(checkbox2);
        Assert.assertFalse(checkbox2.isSelected());

        driver.quit();
    }

    @Test
    void verify3CheckBox() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");

        WebElement cb1 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox1]"));
//        WebElement cb1 = driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']"));
        WebElement cb2 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox2]"));
        WebElement cb3 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox3]"));

        check(cb1);
        Assert.assertTrue(cb1.isSelected());

        check(cb2);
        Assert.assertTrue(cb2.isSelected());

        check(cb3);
        Assert.assertTrue(cb3.isSelected());

        uncheck(cb1);
        Assert.assertFalse(cb1.isSelected());

        uncheck(cb2);
        Assert.assertFalse(cb2.isSelected());

        uncheck(cb3);
        Assert.assertFalse(cb3.isSelected());

        driver.quit();

    }

    @Test
    void verifyCheckAllButtonWorking () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");

        driver.findElement(By.cssSelector("button[data-test=check-all-button]")).click();

        WebElement cb1 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox1]"));
        WebElement cb2 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox2]"));
        WebElement cb3 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox3]"));

        Assert.assertTrue(cb1.isSelected());
        Assert.assertTrue(cb2.isSelected());
        Assert.assertTrue(cb3.isSelected());

        driver.quit();
    }

    @Test
    void verifyUncheckAllButtonWorking () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");

        driver.findElement(By.cssSelector("button[data-test=check-all-button]")).click();
        driver.findElement(By.cssSelector("button[data-test=uncheck-all-button]")).click();

        WebElement cb1 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox1]"));
//        WebElement cb1 = driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']"));
        WebElement cb2 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox2]"));
        WebElement cb3 = driver.findElement(By.cssSelector("input[data-test=checkbox-checkbox3]"));

        Assert.assertFalse(cb1.isSelected() );
        Assert.assertFalse(cb1.isSelected() && cb2.isSelected() && cb3.isSelected());
        Assert.assertFalse(cb1.isSelected() && cb2.isSelected() && cb3.isSelected());
    }

    private void check(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    private void uncheck(WebElement checkbox) {
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

}
