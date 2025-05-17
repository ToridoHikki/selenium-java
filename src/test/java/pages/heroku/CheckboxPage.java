package pages.heroku;

import heroku.Checkbox;
import org.openqa.selenium.By;
import utils.Browser;

import static utils.Browser.*;

public class CheckboxPage {

    public void open() {
        // Open the Checkboxes page
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

//    public void check(Checkbox checkboxName) {
//        Browser.check(checkboxName.getLocator());
//    }
//
//    public void uncheck(Checkbox checkboxName) {
//        Browser.uncheck(checkboxName.getLocator());
//    }
//
//    public boolean isChecked(Checkbox checkboxName) {
//        return Browser.isSelected(checkboxName.getLocator());
//    }

    public void check(String checkboxName){
        Browser.check(By.cssSelector(String.format("input[type=checkbox]:nth-child(%s)", checkboxName)));
    }

    public void uncheck(String checkboxName){
        Browser.uncheck(By.cssSelector(String.format("input[type=checkbox]:nth-child(%s)", checkboxName)));
    }

    public boolean isChecked(String checkboxName){
        return Browser.isSelected(By.cssSelector(String.format("input[type=checkbox]:nth-child(%s)", checkboxName)));
    }


}
