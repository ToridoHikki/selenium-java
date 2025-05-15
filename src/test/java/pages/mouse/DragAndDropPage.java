package pages.mouse;

import static utils.Browser.*;


import org.openqa.selenium.By;

public class DragAndDropPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void dragAndDropTwoColumn(String fromColumn, String toColumn) {
        dragAndDrop(By.id(String.format("column-%s", fromColumn)), By.id(String.format("column-%s", toColumn)));
    }

    public String getResultTextColumnA() {
        return getText(By.cssSelector("#column-a header"));
    }

    public String getResultTextColumnB() {
        return getText(By.cssSelector("#column-b header"));
    }
}
