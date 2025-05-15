package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mouse.DragAndDropPage;
import pages.mouse.HorizontalSliderPage;

import java.time.Duration;

import static utils.Browser.*;

public class MouseActionTest {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @BeforeMethod
    void setup () {
        openBrowser("chrome");
    }

    @Test
    void verifyDragAndDropPOM () throws  InterruptedException {
        dragAndDropPage.open();
        dragAndDropPage.dragAndDropTwoColumn("a", "b");
        Assert.assertTrue(dragAndDropPage.getResultTextColumnB().contains("A"));
        Assert.assertTrue(dragAndDropPage.getResultTextColumnA().contains("B"));
    }


    @Test
    void horizontalSliderTest () throws InterruptedException {

        openBrowser("chrome");

        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();

        horizontalSliderPage.setRange();
        Assert.assertEquals(horizontalSliderPage.getRange(),"5");
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

    @AfterMethod
    void tearDown() {
        quit();
    }
}
