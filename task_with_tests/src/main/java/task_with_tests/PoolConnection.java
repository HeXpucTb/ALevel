package task_with_tests;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PoolConnection {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/geo";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "root";
    private final static int DEFAULT_COUNT_POOL = 8;

    private static ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

    public static Connection createConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public PoolConnection(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < DEFAULT_COUNT_POOL; i++){
            concurrentLinkedQueue.add(createConnection());
        }
    }

    public static Connection getConnection(){
        Connection connection = (Connection) concurrentLinkedQueue.poll();
        if(connection == null){
            connection = createConnection();
        }
        return connection;
    }
}
