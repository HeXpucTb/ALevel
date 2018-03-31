package Task2;

public class Employee2 {
    private String fName;
    private String lName;
    private int salary;

    public Employee2(String fName, String lName, int salary) {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
