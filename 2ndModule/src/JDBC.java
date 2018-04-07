import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {
    private static String csvFilePath = "/home/aleksandr/class.csv";
    private final static String URL = "jdbc:mysql://localhost:3306/class";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    public static void main(String[] args) {
        System.setProperty("com.mysql.jdbc.Driver", "/home/aleksandr/Java/mysqldriver/mysql-connector-java-5.1.46/mysql-connector-java-5.1.46-bin");
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement statement = connection.createStatement()){
            int count= 0;
            for (String str: FileUtils.readFile(csvFilePath)) {
                ArrayList<String> columns = FileUtils.parseCsvString(str);
                if(count==0){
                    statement.execute(SQLUtils.createTable(columns, "class"));
                }

                count++;
                //statement.executeQuery(" ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
