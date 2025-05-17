package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browser;

import java.util.*;
import java.util.stream.Collectors;

import static utils.Browser.openBrowser;
import static utils.Browser.visit;

public class WebTableTest {
    //    Open browser
    //    Navigate to https://the-internet.herokuapp.com/tables
    //    Focus on table 1
    //    The person who has largest due is "Doe Jacson"
    @Test

    void verifyTable () throws InterruptedException {

        openBrowser("chrome");
        visit("https://the-internet.herokuapp.com/tables");
        /**
         *    1. get row index of max due -> get last name/first name
         *         due column xpath //table[@id='table1']/tbody/tr/td[4]
         *         last name column xpath //table[@id='table1']/tbody/tr[row_index]/td[1]
         *         first name column xpath //table[@id='table1']/tbody/tr[row_index]/td[2]
         */

        List <Double> dueList = Browser.getDriver().findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$","")))
                .collect(Collectors.toList());

        System.out.println("dueList " + dueList);

        double maxDue = Collections.max(dueList);
        System.out.println("max " + maxDue);
        int rowIndex = dueList.indexOf(maxDue) + 1;

        String lastName = Browser.getDriver()
                .findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[1]"))
                .getText();
        String firstName = Browser.getDriver()
                .findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]"))
                .getText();

        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
    }

    @Test
    void verifyMinDuePerson () throws InterruptedException {

        openBrowser("chrome");
        visit("https://the-internet.herokuapp.com/tables");

        /**
         * 1.tao list tat ca cac due
         * 2. lay list min due
         * 3. lay index min due
         * 4. lay last name, first name của row index min due
         *
         */

        //todo: tao 1 list  lay tat ca row cua tat ca cac row

        List<String> rowsList = Browser.getDriver()
                .findElements(By.xpath("//table[@id='table2']/tbody/tr"))
                .stream()
                .map(WebElement::getText)
                .toList();

        //todo: tim min due
        double minDue = rowsList
                .stream()
                .map((rowContent) -> rowContent.split(" "))
                .map(cellContent -> Double.valueOf(cellContent[3].replace("$","")))
                .min(Double::compareTo)
                .get();

        System.out.println("minDue = " + minDue);

        List<String> names = rowsList
                .stream()
                .map((rowContent) -> rowContent.split(" "))
                .filter(cellContent -> Double.parseDouble(cellContent[3].replace("$","")) == minDue)
                .map(cellContent -> String.format("%s %s", cellContent[0], cellContent[1]))
                .toList();

        System.out.println("names = " + names);

        Assert.assertEquals(names, List.of("Smith John", "Conway Tim"));

    }
//    @Test
//    void tc07(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/tables");
//
//        List<Person> personList = new ArrayList<>();
//
//        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
//                .forEach(row -> {
//                    String lastName = row.findElement(By.xpath("./td[1]")).getText();
//                    String firstName = row.findElement(By.xpath("./td[2]")).getText();
//                    double due = Double.parseDouble(row.findElement(By.xpath("./td[4]")).getText().replace("$", ""));
//                    personList.add(new Person( firstName,lastName, due));
//                });
//        double minDue = personList.stream().min(Comparator.comparing(Person::getDue)).get().getDue();
//        List<String> listPersonHaveMinDue  = personList.stream()
//                .filter(p -> p.getDue() == minDue)
//                .map(Person::getFullName)
//                .toList();
//
//        Assert.assertEquals(listPersonHaveMinDue, List.of("John Smith","Tim Conway"));
//        driver.quit();
//    }

}
