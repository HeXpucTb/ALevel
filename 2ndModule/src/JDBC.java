import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBC {
    private final static String URL = "jdbc:mysql://localhost:3306/class";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    public static void main(String[] args) {
        System.setProperty("com.mysql.jdbc.Driver", "/home/aleksandr/Java/mysqldriver/mysql-connector-java-5.1.46/mysql-connector-java-5.1.46-bin");
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement statement = connection.createStatement()){
            int count= 0;
            for (String str: FileUtils.readFile("/home/aleksandr/class.csv")) {
                ArrayList<String> columns = FileUtils.parseCsvString(str);
                if(count==0){
                    statement.execute(SQLUtils.deleteTableIfExists("class"));
                    statement.execute(SQLUtils.createTable(columns));
                    count++;
                    continue;
                }
                statement.execute(SQLUtils.fillTable(columns));
                count++;
            }
            printResult(statement.executeQuery(SQLUtils.getClassInfo(readQuery())));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static String readQuery(){
        System.out.println("Enter class name you're looking for:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    private static void printResult(ResultSet result) throws SQLException {
        if(!result.next()){
            System.out.println("Wrong class name!");
        }else {
                System.out.print(result.getString(1)+" ");
                System.out.print(result.getString(2)+" ");
                System.out.print(result.getString(3)+" ");
        }

    }
}
