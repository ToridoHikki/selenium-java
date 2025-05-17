package pages.mouse;

import utils.Browser;

import static utils.Browser.visit;

public class InfiniteScrollPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/infinite_scroll");
    }

    public void scroll(int x, int y) throws InterruptedException {
        for (int i = 0; i  < 5; i++) {
            Browser.scroll(x,y);
            Thread.sleep(1000);
        }
    }


}
