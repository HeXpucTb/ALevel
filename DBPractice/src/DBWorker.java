import java.sql.*;

public class DBWorker {
    private final static String URL = "jdbc:mysql://localhost:3306/employees";
    private final static String USER = "root";
    private final static String PASS = "vfnth";

    public static void main(String[] args) {
        String query = "SELECT COUNT(*) FROM employees";
        int count = 0;
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)){

            while (rs.next()){
                count = rs.getInt(1);
            }
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
