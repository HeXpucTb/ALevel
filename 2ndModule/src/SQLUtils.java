import java.util.ArrayList;

public abstract class SQLUtils {
    private static String primaryKey;
    private static String tName;
    public static String createTable(ArrayList<String> columns){
        primaryKey = columns.get(0);
        return  "CREATE TABLE class."+tName+" ("+
                primaryKey +" VARCHAR(3), "+
                columns.get(1) +" INT(3), "+
                columns.get(2) +" VARCHAR(100), "+
                "PRIMARY KEY ("+primaryKey+"));";
    }
    public static String getClassInfo(String userQery){
        return "SELECT * FROM "+tName+" WHERE "+primaryKey+"='"+userQery+"';";
    }

    public static String deleteTableIfExists(String name){
        tName = name;
        return "DROP TABLE IF EXISTS class."+tName;
    }
    public static String fillTable(ArrayList<String> data){
        return "INSERT INTO "+tName+" VALUES ('"+data.get(0)+"','"+data.get(1)+"','"+data.get(2)+"');";
    }

}