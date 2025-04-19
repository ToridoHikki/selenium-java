package heroku;

public class Person {
    private String lastName;
    private String firstName;
    private String due;

    public Person (String lastName, String firstName, String due) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.due = due;
    }

    public String getFullName () {
        return String.format("%s %s", lastName, firstName);
    }

    public double getDue() {
        return Double.valueOf(due.replace("$",""));
    }
}
