package prosky.skyprospringdemosethw.employee;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
