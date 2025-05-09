package heroku;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.heroku.FormAuthenticationPage;

import static utils.Browser.*;

//import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class FormAuthenticationTest  extends TestBase {

    FormAuthenticationPage formAuthenticationPage;

    @BeforeClass

    void setup() {
        openBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
    }

    @Parameters({"browser"})
    @Test
    void verifyForm(String browser) throws InterruptedException {
        formAuthenticationPage
                .open()
                .login("tomsmith","SuperSecretPassword!");

        Assert.assertTrue(formAuthenticationPage
                .getWelcomeMessage()
                .contains("Welcome to the Secure Area. When you are done click logout below."));
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
