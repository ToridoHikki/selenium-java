package pages.moatazeldebsy;

import org.openqa.selenium.By;
import utils.Browser;

import static utils.Browser.click;
import static utils.Browser.visit;

public class CheckboxesPage {

    public void open() {
        visit("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    }

    public void checkAll() {
        click(By.cssSelector("button[data-test='check-all-button']"));
    }
    public void uncheckAll() {
        click(By.cssSelector("button[data-test='uncheck-all-button']"));
    }

    public void check(String checkboxName) {
        Browser.check(By.cssSelector(String.format("input[data-test=checkbox-checkbox%s]", checkboxName)));
    }

    public void uncheck(String checkboxName) {
        Browser.uncheck(By.cssSelector(String.format("input[data-test=checkbox-checkbox%s]", checkboxName)));
    }

    public boolean isChecked(String checkboxName) {
        return Browser.isSelected(By.cssSelector(String.format("input[data-test=checkbox-checkbox%s]", checkboxName)));
    }
}
