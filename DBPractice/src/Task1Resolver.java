import Task1.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task1Resolver {
    private final static String URL = "jdbc:mysql://localhost:3306/employees";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    private static List<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {
        String query = "SELECT employees.first_name, employees.last_name, employees.hire_date FROM employees.employees";
        String fName;
        String lName;
        Date hDate ;
        int i = 0;
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)){

            while (rs.next()&&i<200) {
                fName = rs.getString(1);
                lName = rs.getString(2);
                hDate = rs.getDate(3);
                employees.add(new Employee(fName,lName,hDate));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printList();
    }
    private static void printList(){
        for (Employee ex: employees) {
            System.out.println(ex.toString());
        }
    }
}
