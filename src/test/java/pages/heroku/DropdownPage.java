package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.getSelect;
import static utils.Browser.visit;

public class DropdownPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String option) {
        getSelect(By.id("dropdown"))
                .selectByVisibleText(option);

    }

    public void selectOptionByValue(String value) {
        getSelect(By.id("dropdown"))
                .selectByValue(value);
    }

    public void selectOptionByIndex(int index) {
        getSelect(By.id("dropdown"))
                .selectByIndex(index);
    }

    public boolean isOptionDisplay(String option) {
        return getSelect(By.id("dropdown"))
                .getOptions()
                .stream()
                .anyMatch(webElement -> webElement.getText().equals(option));

    }

    public boolean isOptionDisplayByValue(String value) {
        return getSelect(By.id("dropdown"))
                .getOptions()
                .stream()
                .anyMatch(webElement -> webElement.getAttribute("value").equals(value));

    }

public boolean isOptionDisplayByIndex(int index) {
           return index >= 0 && index < getSelect(By.id("dropdown"))
                   .getOptions()
                   .size();
       }


}
