package pages.mouse;

import org.openqa.selenium.By;
import utils.Browser;

import static utils.Browser.click;
import static utils.Browser.visit;

public class HyperLinkPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickLinkText(String linkText) {
        click(By.linkText(linkText));
    }

    public String getText() {
        return Browser.getText(By.id("content"));
    }

    public boolean isPageLoaded(String statusCode) {
        return Browser.getCurrentUrl().contains("https://the-internet.herokuapp.com/status_codes/" + statusCode);
    }



}
