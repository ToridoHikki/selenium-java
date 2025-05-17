package pages.mouse;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class DynamicLoadingPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void clickStart() {
        click(By.xpath("//button[.='Start']"));
    }

    public String getFinishText() {
        return getText(By.id("finish"));
    }
}
