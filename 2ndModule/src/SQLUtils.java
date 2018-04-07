import java.util.ArrayList;

public abstract class SQLUtils {
    public static String createTable(ArrayList<String> columns, String name){
        return  "DROP TABLE IF EXISTS "+name+" ;"+
                "CREATE TABLE "+name+" ("+
                columns.get(0) +" VARCHAR(3) , "+
                columns.get(1) +" INT(3) NOT NULL, "+
                columns.get(2)+" VARCHAR(100) NOT NULL)";
    }
    /*public static String executeQuery(ArrayList<String> str){

    }
    public static String executeUpdateQuery(ArrayList<String> str){

        return ;
    }*/
}