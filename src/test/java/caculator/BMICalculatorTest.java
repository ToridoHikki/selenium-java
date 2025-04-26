package caculator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.caculator.BMIPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class BMICalculatorTest {

    BMIPage bmiPage;
    @BeforeMethod
    void setup(){
        openBrowser("chrome");
        bmiPage = new BMIPage();
        bmiPage.open();
        bmiPage.selectUnitMetric();
        bmiPage.clearForm();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"25","male", "175", "70", "BMI = 22.9 kg/m2   (Normal)"},
                {"25","male", "175", "90", "BMI = 29.4 kg/m2   (Overweight)"},
                {"25","male", "175", "100", "BMI = 32.7 kg/m2   (Obese Class I)"},
        };
    }


    @Test(dataProvider = "testData")
    void verifyNormalClassification(String age,String gender, String height, String weight, String expectedResult) {
        bmiPage.fillForm(age, gender, height, weight);
        Assert.assertEquals(bmiPage.getResultText(),expectedResult);
    }

    @AfterMethod
    void tearDown(){
        quit();
    }

}
