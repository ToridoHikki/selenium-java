package pages.mouse;

import org.openqa.selenium.By;
import utils.Browser;

import static utils.Browser.visit;

public class ContextMenuPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void rightClick() {
        Browser.rightClick(By.id("hot-spot"));
    }

    public String getAlertText() {
        return Browser.getAlertText();
    }

    public void acceptAlert() {
        Browser.getDriver().switchTo().alert().accept();
    }
}
