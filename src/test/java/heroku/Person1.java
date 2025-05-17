package heroku;

public class Person1 {

        private String firstName,lastname;
        private double due;

        public Person1(String firstName, String lastname, double due) {
            this.firstName = firstName;
            this.lastname = lastname;
            this.due = due;
        }


        public void info(){
            System.out.printf("First name: %s ,last name: %s, due: %.2f%n", firstName,lastname,due);
        }
        public double getDue() {
            return due;
        }
        public String getFullName() {
            return String.format("%s %s", firstName, lastname);
        }
}
