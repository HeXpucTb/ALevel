import Task3.Employee3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task3Resolver {
    private final static String URL = "jdbc:mysql://localhost:3306/employees";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    private static List<Employee3> employees = new ArrayList<>();

    public static void main(String[] args) {
        String query = "SELECT employees.first_name\n" +
                "FROM employees\n" +
                "WHERE employees.last_name LIKE ?\n";
        String findName = "K%";
        int count = 0;
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            PreparedStatement statement = connection.prepareStatement(query)){
            try{
                statement.setString(1,findName);
                ResultSet rs = statement.executeQuery();
                while (rs.next()&&count<500){
                    employees.add(new Employee3(rs.getString(1)));
                    count++;
                }
                rs.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printList();
    }
    private static void printList(){
        for (Employee3 ex: employees) {
            System.out.println(ex.toString());
        }
    }
}
