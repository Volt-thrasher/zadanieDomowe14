public class Sportsman {
    private String  firstName;
    private String lastName;
    private double result;

    public Sportsman(String firstName, String lastName, double result) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.result = result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Imie: " + firstName + '\'' +
                ", lastName: " + lastName + '\'' +
                ", result: " + result;
    }
}
