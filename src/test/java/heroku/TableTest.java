package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mouse.TablePage;

import java.util.List;
import java.util.OptionalDouble;

import static utils.Browser.openBrowser;

public class TableTest {

    @Test
    void verifyMaxDuePerson () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> people = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .stream()
                .map(WebElement::getText)
                .map(rowContent -> rowContent.split(" "))
                .map(cellContent -> new Person(cellContent[0], cellContent[1], cellContent[3]))
                .toList();


        OptionalDouble maxDue = people
                .stream()
                .mapToDouble(Person::getDue)
                .max();

        List<Person> maxDuePersons = people
                .stream()
                .filter(p -> p.getDue() == maxDue.getAsDouble())
                .toList();

        List<String> maxDuePersonsFullName = maxDuePersons
                .stream()
                .map(Person::getFullName)
                .toList();

        System.out.println("maxDuePersonsFullName = " + maxDuePersonsFullName);

        Assert.assertEquals(maxDuePersonsFullName, List.of("Jason Doe"));



//        Assert.assertEquals(maxDuePersons
//                .stream()
//                .map(Person::getFullName)
//                .toList(), List.of("Jason Doe"));
    }

    @Test
    public void verifyMaxDuePersonPOM() {
        openBrowser("chrome");
        TablePage tablePage = new TablePage();
        tablePage.open();

        Assert.assertEquals(tablePage.getMaxDuePersonsFullName(), List.of("Doe Jason"));
    }

    @Test
    public void verifyMinDuePersonPOM() {
        openBrowser("chrome");
        TablePage tablePage = new TablePage();
        tablePage.open();

        Assert.assertEquals(tablePage.getMinDuePersonsFullName(), List.of("Smith John", "Conway Tim"));
    }

    @Test
    void verifyMinDuePerson () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        //Todo: tao 1 list Person lấy text của tất cả các row
        List<Person> people = driver
                .findElements(By.xpath("//table[@id='table2']/tbody/tr"))
                .stream()
                //Lay text cua tat ca cac row
                .map(rowText -> rowText.getText())
                //Tach text ra thanh cac cell, tach bang space
                .map(rowContent -> rowContent.split(" "))
                // Tao 1 object Person tu cac cell
                .map(cellContent -> new Person(cellContent[0], cellContent[1], cellContent[3]))
                //chuyen ve list
                .toList();

        System.out.println("List people = " + people);

        //Todo: tim minDue trong due
        OptionalDouble minDue = people
                .stream()
                .mapToDouble(p -> p.getDue())
                .min();

        System.out.println("OptionalDouble mindue = " + minDue);

        //Todo: tim person co min due
        List<Person> minDuePersons = people
                .stream()
                .filter(p -> p.getDue() == minDue.getAsDouble())
                .toList();

        System.out.println("List minDuePersons = " + minDuePersons);


        //Todo: verify
        Assert.assertEquals(minDuePersons
                .stream()
                .map(p -> p.getFullName()).toList(), List.of("Smith John", "Conway Tim"));
    }



}
