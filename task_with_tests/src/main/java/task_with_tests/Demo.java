package task_with_tests;
public class Demo {
    public static void main(String[] args) {
        PoolConnection pool = new PoolConnection();
        pool.createConnection();
        pool.getConnection();
    }
}