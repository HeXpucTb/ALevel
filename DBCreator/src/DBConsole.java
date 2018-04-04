import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBConsole {
    private static String txtFilePath;
    private static String csvFilePath;
    private static String sqlFilePath;
    private static String schName;
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    public static void main(String[] args) {
        initVars();
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement statement = connection.createStatement()){
            int count= 0;
            for (String str: FileUtils.readFile(csvFilePath)) {
                ArrayList<String> columns = FileUtils.parseCsvString(str);
                if(count==0){
                    statement.execute(SQLUtils.createTable(columns, getTableName() ));
                }

                count++;
                statement.executeQuery(" ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private static String getTableName(){
        int index1 = csvFilePath.lastIndexOf(File.separatorChar);
        int index2 = csvFilePath.lastIndexOf(".");

        return csvFilePath.substring(index1,index2);
    }
    private static String pathReader(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    private static void initVars(){
        System.out.println("Enter csv path:");
        csvFilePath = pathReader();
        System.out.println("Enter txt path:");
        txtFilePath = pathReader();
        System.out.println("Enter sql path:");
        sqlFilePath = pathReader();
        System.out.println("Enter DB schema's name:");
        schName = pathReader();
    }
}
