package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActionTest {

    @Test
    void dragAndDropVerify () throws  InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        action.dragAndDrop(source, target).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("#column-a header")).getText().contains("B"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#column-b header")).getText().contains("A"));

        driver.quit();
    }

    @Test
    void horizontalSliderTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.cssSelector(".sliderContainer input[type=range]"));
//        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        action.clickAndHold(slider)
                .moveByOffset((int) (slider.getSize().getWidth() * 0.1), 0)
                .release()
                .perform();

        String range = driver.findElement(By.id("range")).getText();
        Assert.assertEquals(range,"3");

    }

    @Test
    void infiniteScrollTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions action = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            action.scrollByAmount(0,100).perform();
            Thread.sleep(1000);
        }
        driver.quit();
    }

    @Test
    void contextMenuTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

        driver.quit();
    }
    @Test
    void verifyDynamicLoading(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String finishText = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("finish")))
                .getText();
        Assert.assertTrue(finishText.contains("Hello World!"));

    }
}
