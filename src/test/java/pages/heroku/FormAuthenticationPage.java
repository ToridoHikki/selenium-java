package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class FormAuthenticationPage  {

    public FormAuthenticationPage open() {
        // Open the Form Authentication page
        visit("https://the-internet.herokuapp.com/login");
        return this;
    }

    public void fillForm(String username, String password) {
        // Fill in the username and password fields
        fill(By.id("username"), username);
        fill(By.id("password"), password);
    }

    public void clickLogin() {
        // Click the login button
        click(By.cssSelector("button[type=submit]"));
    }

    public void login (String username, String password) {
        // Fill in the form and click login
        fillForm(username, password);
        clickLogin();
    }
    public String getWelcomeMessage() {
        // Get the success message after login
        return getText(By.tagName("h4"));
    }


}
