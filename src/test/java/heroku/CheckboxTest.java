package heroku;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.moatazeldebsy.CheckboxPage;

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
        pages.heroku.CheckboxPage checkboxPage = new pages.heroku.CheckboxPage();
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
        pages.moatazeldebsy.CheckboxPage checkboxPage = new pages.moatazeldebsy.CheckboxPage();
        checkboxPage.open();

        checkboxPage.checkAll();
        Assert.assertTrue(checkboxPage.isChecked("1"));
        Assert.assertTrue(checkboxPage.isChecked("2"));
        Assert.assertTrue(checkboxPage.isChecked("3"));

        checkboxPage.uncheckAll();
        Assert.assertFalse(checkboxPage.isChecked("1"));
        Assert.assertFalse(checkboxPage.isChecked("2"));
        Assert.assertFalse(checkboxPage.isChecked("3"));
    }

    @Test
    void verifyCheckAllButtonWorking () throws InterruptedException {
        openBrowser("chrome");
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();

        checkboxPage.checkAll();
        Assert.assertTrue(checkboxPage.isChecked("1"));
        Assert.assertTrue(checkboxPage.isChecked("2"));
        Assert.assertTrue(checkboxPage.isChecked("3"));

    }

    @Test
    void verifyUncheckAllButtonWorking () throws InterruptedException {
        openBrowser("chrome");
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();

        checkboxPage.checkAll();
        checkboxPage.uncheckAll();
        Assert.assertFalse(checkboxPage.isChecked("1"));
        Assert.assertFalse(checkboxPage.isChecked("2"));
        Assert.assertFalse(checkboxPage.isChecked("3"));
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
