package heroku;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.heroku.FormAuthenticationPage;

import static utils.Browser.*;

//import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class FormAuthenticationTest extends TestBase {

    FormAuthenticationPage formAuthenticationPage;

    @BeforeClass
    @Parameters({"browser"})

    void setup(String browser) {
        openBrowser(browser);
        formAuthenticationPage = new FormAuthenticationPage();
    }
    @Test
    void verifyForm() throws InterruptedException {
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
