package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.heroku.CheckboxPage;
import pages.moatazeldebsy.CheckboxesPage;

import static utils.Browser.*;


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
        openBrowser("chrome");
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();

        checkboxPage.check("1");
        Assert.assertTrue(checkboxPage.isChecked("1"));

        checkboxPage.check("3");
        Assert.assertTrue(checkboxPage.isChecked("3"));

        checkboxPage.uncheck("1");
        Assert.assertFalse(checkboxPage.isChecked("1"));

        checkboxPage.uncheck("3");
        Assert.assertFalse(checkboxPage.isChecked("3"));
    }

    @Test
    void verify3CheckBox() throws InterruptedException {
        openBrowser("chrome");
        CheckboxesPage checkboxesPage= new CheckboxesPage();
        checkboxesPage.open();

        checkboxesPage.checkAll();
        Assert.assertTrue(checkboxesPage.isChecked("1"));
        Assert.assertTrue(checkboxesPage.isChecked("2"));
        Assert.assertTrue(checkboxesPage.isChecked("3"));

        checkboxesPage.uncheckAll();
        Assert.assertFalse(checkboxesPage.isChecked("1"));
        Assert.assertFalse(checkboxesPage.isChecked("2"));
        Assert.assertFalse(checkboxesPage.isChecked("3"));
    }

    @Test
    void verifyCheckAllButtonWorking () throws InterruptedException {
        openBrowser("chrome");
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();

        checkboxesPage.checkAll();
        Assert.assertTrue(checkboxesPage.isChecked("1"));
        Assert.assertTrue(checkboxesPage.isChecked("2"));
        Assert.assertTrue(checkboxesPage.isChecked("3"));

    }

    @Test
    void verifyUncheckAllButtonWorking () throws InterruptedException {
        openBrowser("chrome");
        CheckboxesPage checkboxesPage= new CheckboxesPage();
        checkboxesPage.open();

        checkboxesPage.checkAll();
        checkboxesPage.uncheckAll();
        Assert.assertFalse(checkboxesPage.isChecked("1"));
        Assert.assertFalse(checkboxesPage.isChecked("2"));
        Assert.assertFalse(checkboxesPage.isChecked("3"));
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

    @AfterMethod
    public void tearDown() {
        quit();
    }

}
