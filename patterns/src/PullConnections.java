import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PullConnections {
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    private ConcurrentLinkedQueue<Connection> connections = new ConcurrentLinkedQueue<>();
    public PullConnections(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 8; i++) {
            connections.add(createConnection());
        }
    }
    private Connection createConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Connection getConnection() {
        Connection conn = connections.poll();
        if(conn==null){
            conn = createConnection();
        }
        return conn;
    }
    public boolean closeConnection(Connection conn){
        return connections.offer(conn);
    }
    public boolean closeAllConnections(){
        for (Connection conn: connections) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
