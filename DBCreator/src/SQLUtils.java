import java.util.ArrayList;

public abstract class SQLUtils {
    public static String createTable(ArrayList<String> columns, String name){
        return  "CREATE TABLE"+ (
                pos_id INT AUTO_INCREMENT,
                pos_name VARCHAR(50) NOT NULL,
                pos_price DOUBLE NOT NULL,
                PRIMARY KEY (pos_id)
        )
    }
    addKeys(){

    }
    public static String executeQuery(ArrayList<String> str){

    }
    public static String executeUpdateQuery(ArrayList<String> str){

        return ;
    }
}
