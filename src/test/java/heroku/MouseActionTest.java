package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mouse.*;

import static utils.Browser.*;

public class MouseActionTest {


    @BeforeMethod
    void setup() {
        openBrowser("chrome");
    }

    @Test
    void verifyDragAndDropPOM() throws InterruptedException {
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.open();

        dragAndDropPage.dragAndDropTwoColumn("a", "b");
        Assert.assertTrue(dragAndDropPage.getResultTextColumnB().contains("A"));
        Assert.assertTrue(dragAndDropPage.getResultTextColumnA().contains("B"));
    }


    @Test
    void horizontalSliderTest() throws InterruptedException {

        openBrowser("chrome");

        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();

        horizontalSliderPage.setRange();
        Assert.assertEquals(horizontalSliderPage.getRange(), "5");
    }

    @Test
    void infiniteScrollTest() throws InterruptedException {

        openBrowser("chrome");
        InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage();
        infiniteScrollPage.open();

        infiniteScrollPage.scroll(0, 100);


//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
//
//        Actions action = new Actions(driver);
//        for (int i = 0; i < 5; i++) {
//            action.scrollByAmount(0,100).perform();
//            Thread.sleep(1000);
//        }
//        driver.quit();
    }

    @Test
    void contextMenuTest() {
        openBrowser("chrome");
        ContextMenuPage contextMenuPage = new ContextMenuPage();
        contextMenuPage.open();

        contextMenuPage.rightClick();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
        contextMenuPage.acceptAlert();
    }

    @Test
    void verifyDynamicLoading() {
        openBrowser("chrome");
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();

        dynamicLoadingPage.clickStart();
        Assert.assertTrue(dynamicLoadingPage.getFinishText().contains("Hello World!"));

    }

    @AfterMethod
    void tearDown() {
        quit();
    }
}
