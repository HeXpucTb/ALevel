package Task1;

public class Employee {
    private String firstName;
    private String lastName;
    private java.sql.Date hireDate;

    public Employee(String firstName, String lastName, java.sql.Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
