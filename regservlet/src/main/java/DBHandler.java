import java.sql.*;
import java.util.ArrayList;

public abstract class DBHandler {
    private final static String URL = "jdbc:mysql://localhost:3306/users";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    public static ArrayList<String> initGet(String query) {
        ArrayList<String> ansList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement st = connection.createStatement()){
            ResultSet answer =  st.executeQuery(query);
            for (int i = 1; answer.next();i++){
                ansList.add(answer.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ansList;
    }
    public static void initPost (String query) throws SQLException {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement st = connection.createStatement()){
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}