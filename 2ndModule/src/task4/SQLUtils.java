package task4;

import java.util.ArrayList;
import java.util.Scanner;

abstract class SQLUtils {
    private static String newEntName;
    private static ArrayList<String> entNames;
    private static int entNumber;
    private static Scanner sc;
    static String createUserTable(){
        entNames = new ArrayList<>();
        sc = new Scanner(System.in);
        entNames.add("usr_id_like");
        return "CREATE TABLE users (usr_id INT AUTO_INCREMENT, usr_name VARCHAR(300), PRIMARY KEY (usr_id));";
    }
    static String createFotoTable(){
        entNames.add("foto_id_like");
        return "CREATE TABLE fotos (foto_id INT AUTO_INCREMENT, foto_name VARCHAR(300), usr_id INT"+
                ", PRIMARY KEY (foto_id)"+
                ", FOREIGN KEY (usr_id) REFERENCES users(usr_id));";
    }
    static String createCommentsTable(){
        entNames.add("comm_id_like");
        return "CREATE TABLE comments (comm_id INT AUTO_INCREMENT, comm_text VARCHAR(2000), usr_id INT"+
                ", foto_id INT,"+
                " PRIMARY KEY (comm_id),"+
                " FOREIGN KEY (usr_id) REFERENCES users(usr_id),"+
                " FOREIGN KEY (foto_id) REFERENCES fotos(foto_id));";
    }
    static String createLikesTable(){
        return "CREATE TABLE likes (like_id INT AUTO_INCREMENT, usr_id INT, usr_id_like INT, foto_id_like INT,"+
                " comm_id_like INT, status ENUM('yes','no'),"+
                " PRIMARY KEY (like_id),"+
                " FOREIGN KEY (usr_id) REFERENCES users(usr_id),"+
                " FOREIGN KEY (usr_id_like) REFERENCES users(usr_id),"+
                " FOREIGN KEY (foto_id_like) REFERENCES fotos(foto_id),"+
                " FOREIGN KEY (comm_id_like) REFERENCES comments(comm_id),"+
                " CONSTRAINT likes UNIQUE (usr_id, usr_id_like, foto_id_like, comm_id_like));";
    }
    static String insertUsrData(){
        return "INSERT INTO users (usr_name) VALUES ('default'), ('Ivan'), ('Bogdan'), ('Viktor'), ('Daniil'), ('Petr');";
    }
    static String insertFotoData(){
        return "INSERT INTO fotos (foto_name, usr_id) VALUES('default','1'),"+
                " ('Pic1','2'), ('Pic2','2'), ('Pic3','3'), ('Pic4','3'), ('Pic5','4'),"+
                " ('Pic6','4'), ('Pic7','5'), ('Pic8','5');";
    }
    static String insertCommData(){
        return "INSERT INTO comments (comm_text, usr_id, foto_id) VALUES"+
                " ('default','1','1'), ('January','2','2'), ('February','2','3'), ('March','2','4'), ('April','2','5'),"+
                " ('May','3','6'), ('June','3','7'), ('July','4','8'), ('August','4','9');";
    }
    static String addEntity(){
        System.out.println("Enter entity name:");
        newEntName = sc.next();
        StringBuilder query = new StringBuilder("CREATE TABLE " +newEntName+ " (");
        newEntName+="_id_like";
        entNames.add(newEntName);
        String result = "";
        ArrayList<String> columns = fillString();
        if(!columns.isEmpty()){
          result = buildString(columns,query)+setPrimaryKey(columns)+setForeignKeys(columns)+")";
        }
        result =addEntColumnToLikesTable()+result;
        return result;
    }
    private static String addEntColumnToLikesTable(){
        return "ALTER TABLE likes ADD "+newEntName+" INT DEFAULT 1; ";
    }
    private static ArrayList<String> fillString(){
        sc.nextLine();
        boolean all = false;
        ArrayList<String> columns = new ArrayList<>();
        do{
            System.out.println("Enter column with data type through space:(enter 0 if enough)");
            String col = sc.nextLine();
            if(col.equals("0")){
                all = true;
            }else {
                columns.add(col);
            }
        }while (!all);
        return columns;
    }
    private static String buildString(ArrayList<String> columns, StringBuilder query){
        for (String ex: columns) {
            query.append(ex).append(", ");
        }
        query.setLength(query.length()-2);
        return query.toString();
    }
    private static String setPrimaryKey(ArrayList<String> columns){
        System.out.println("set primary key:");
        printColumns(columns);
        String res = columns.get(sc.nextInt());
        return ", PRIMARY KEY ("+res.substring(0,res.indexOf(" "))+")";
    }
    private static String setForeignKeys(ArrayList<String> columns){
        boolean exit = false;
        String result;
        String str1 = ", FOREIGN KEY (";
        String str2 = ") REFERENCES ";
        int n;
        do{
            System.out.println("set foreign key:");
            printColumns(columns);
            n = sc.nextInt();
            if(n<0||n>=columns.size()){
                return "";
            }
            String res = columns.get(n);
            result = str1+res.substring(0,res.indexOf(" "))+str2;
            System.out.println("enter ref. table:");
            result +=sc.next()+"(";
            System.out.println("enter ref. column:");
            result+=sc.next()+")";
            System.out.println("That's all?(y/n)");
            if(sc.next().equals("y")){
                exit = true;
            }
        }while (!exit);
        return result;
    }
    private static void printColumns(ArrayList<String> columns){
        for (int i = 0; i<columns.size();i++) {
            System.out.print(i+" - "+columns.get(i)+"; ");
        }
        System.out.println();
    }
    public static String addLike(){
        String[] details = setEntity();
        return fillEntitiesForSelect(details);
    }
    public static String cancelLike(){
        int likeId = selectLikeForCancel();
        return "UPDATE likes SET status='no' WHERE like_id="+likeId;
    }
    private static int selectLikeForCancel(){
        System.out.println("enter like_id you want to cancel:");
        return sc.nextInt();
    }
    private static String[] setEntity(){
        String[] entityDetails = new String[2];
        System.out.println("enter your usr_id:");
        entityDetails[0] = sc.next();
        System.out.println("select entity:");
        for (int i = 0;i<entNames.size();i++) {
            System.out.println(i+" "+entNames.get(i));
        }
        entNumber = sc.nextInt();
        System.out.println("enter entity id:");
        entityDetails[1] = sc.next();
        return entityDetails;
    }
    public static String showUsersMadeLikes(){
        return "SELECT usr_name FROM users INNER JOIN likes ON (users.usr_id = likes.usr_id_like)"+
                " WHERE likes.status LIKE 'yes';";
    }
    public static String showCurrentUsrLikes(){
        System.out.println("Enter your user id:");
        return "SELECT * FROM likes WHERE usr_id="+sc.nextInt();
    }
    private static String fillEntitiesForSelect(String[] details){
        String result = "INSERT INTO likes (usr_id, ";
        for (String ex: entNames) {
            result+=ex+", ";
        }
        result+="status) VALUES ("+details[0];
        for(int i = 0; i<entNames.size(); i++){
            if(i==entNumber){
                result+=","+details[1];
            }else{
                result+=",1";
            }
        }
        result+=",'yes');";
        return result;
    }
    public static ArrayList<String> getEntNames() {
        return entNames;
    }
    public static String showEntityLikes(){
        return selectEntityForShowLikes();
    }
    private static String selectEntityForShowLikes(){
        System.out.println("Select entity:");
        printEntities();
        String ent = entNames.get(sc.nextInt());
        System.out.println("enter entity id");
        return "SELECT count(like_id) FROM likes WHERE "+ent+"="+sc.nextInt()+" AND status='yes'";
    }
    public static void closeScaner(){
        sc.close();
    }
    private static void printEntities(){
        int i = 0;
        for (String ex: entNames) {
            System.out.print(i+" - "+ex+", ");
            i++;
        }
        System.out.println();
    }
}
