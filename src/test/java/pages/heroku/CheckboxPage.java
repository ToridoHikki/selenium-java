package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class CheckboxPage {

    public void open () {
        // Open the Checkboxes page
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void uncheck(By by) {
        if (getDriver().findElement(by).isSelected()) {
            getDriver().findElement(by).click();
        }

    }





}
