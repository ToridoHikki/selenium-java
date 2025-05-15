package pages.mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;

import static utils.Browser.visit;

public class HorizontalSliderPage {

    public void open() {
        // Open the Horizontal Slider page
        visit("https://the-internet.herokuapp.com/horizontal_slider");
    }

    public void setRange() {
        Browser.slider(By.cssSelector(".sliderContainer input[type=range]"),100, 0);
    }

    public String getRange() {
        return Browser.getText(By.id("range"));
    }






}
