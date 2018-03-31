import Task1.Employee;
import Task2.Employee2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task2Resolver {
    private final static String URL = "jdbc:mysql://localhost:3306/employees";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    private static List<Employee2> employees = new ArrayList<>();

    public static void main(String[] args) {
        String year = "2000";
        int i = 0;
        String fName;
        String lName;
        int salary;
        String query = "SELECT employees.first_name, employees.last_name, sal.salary " +
                "FROM employees " +
                "INNER JOIN salaries sal ON (employees.emp_no=sal.emp_no) " +
                "WHERE sal.to_date LIKE ?";
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            PreparedStatement statement = connection.prepareStatement(query)){
            try {
                statement.setString(1, year + "%");
                ResultSet rs = statement.executeQuery();
                while (rs.next() && i < 100) {
                    fName = rs.getString(1);
                    lName = rs.getString(2);
                    salary = rs.getInt(3);
                    employees.add(new Employee2(fName, lName, salary));
                    System.out.println(fName + lName + salary);
                    i++;
                }
                rs.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            printList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void printList(){
        for (Employee2 ex: employees) {
            System.out.println(ex.toString());
        }
    }
}
