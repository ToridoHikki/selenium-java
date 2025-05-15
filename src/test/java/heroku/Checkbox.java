package heroku;

import org.openqa.selenium.By;

public enum Checkbox {
    CHECKBOX1("input[type=checkbox]:nth-child(1)"),
    CHECKBOX2("input[type=checkbox]:nth-child(3)");

    private String locator;

    Checkbox(String locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return By.cssSelector(locator);
    }
}
