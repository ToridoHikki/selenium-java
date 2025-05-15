package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

// selenium owner methods
public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;

    /*
     open browser: chrome, firefox, edge, safari
     return WebDriver
     static method
     */
    public static WebDriver openBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions option = new ChromeOptions();
                option.addArguments("headless");
                driver = new ChromeDriver(option);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Actions getActions() {
        return new Actions(driver);
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }

    public static void click(By by) {
        wait
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    public static void fill(By by, String withText) {
        driver.findElement(by).sendKeys(withText);
    }

    public static boolean isSelected(By by) {
        return driver.findElement(by).isSelected();
    }

    public static void check(By by) {
        if (!isSelected(by)) {
            click(by);
        }
    }

    public static void uncheck(By by) {
        if (isSelected(by)) {
            click(by);
        }
    }

    public static String getText(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void captureScreenshot(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", fileName, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dragAndDrop(By source, By target) {
        getActions().dragAndDrop(driver.findElement(source), driver.findElement(target)).perform();
    }

    public static void slider(By by, int xOffset, int yOffset) {
        WebElement slider = driver.findElement(by);

        getActions().clickAndHold(slider)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }

    public static void scrollInfinite(By by, int yOffset) {
        getActions().scrollByAmount(0, yOffset).perform();
    }

    public static void rightClick(By by) {
        getActions().contextClick(driver.findElement(by)).perform();
    }

    public static void doubleClick(By by) {
        getActions().doubleClick(driver.findElement(by)).perform();
    }


}

