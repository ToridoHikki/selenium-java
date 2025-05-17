package pages.mouse;

import heroku.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.OptionalDouble;

import static utils.Browser.getDriver;
import static utils.Browser.visit;

public class TablePage {
    public void open() {
        visit("https://the-internet.herokuapp.com/tables");
    }

    public List<Person> getPersonsTableOne() {
        return getDriver()
                        .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                        .stream()
                        .map(WebElement::getText)
                        .map(rowContent -> rowContent.split(" "))
                        .map(cellContent -> new Person(cellContent[0], cellContent[1], cellContent[3]))
                        .toList();

    }

    public OptionalDouble getMaxDue() {
        return getPersonsTableOne()
                .stream()
                .mapToDouble(Person::getDue)
                .max();
    }

    public List<Person> getMaxDuePersons() {
        return getPersonsTableOne()
                .stream()
                .filter(p -> p.getDue() == getMaxDue().getAsDouble())
                .toList();
    }

    public List<String> getMaxDuePersonsFullName() {
        return getMaxDuePersons()
                .stream()
                .map(Person::getFullName)
                .toList();
    }

    public List<Person> getPersonsTableTwo() {
        return getDriver()
                .findElements(By.xpath("//table[@id='table2']/tbody/tr"))
                .stream()
                .map(WebElement::getText)
                .map(rowContent -> rowContent.split(" "))
                .map(cellContent -> new Person(cellContent[0], cellContent[1], cellContent[3]))
                .toList();
    }

    public OptionalDouble getMinDue() {
        return getPersonsTableTwo()
                .stream()
                .mapToDouble(Person::getDue)
                .min();
    }

    public List<Person> getMinDuePersons() {
        return getPersonsTableTwo()
                .stream()
                .filter(p -> p.getDue() == getMinDue().getAsDouble())
                .toList();
    }

    public List<String> getMinDuePersonsFullName() {
        return getMinDuePersons()
                .stream()
                .map(Person::getFullName)
                .toList();
    }

}
