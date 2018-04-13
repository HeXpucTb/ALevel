package task4;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.*;
import java.util.ArrayList;

public class SocialNetwork {
    private final static String URL = "jdbc:mysql://localhost:3306/socnetwork?allowMultiQueries=true";
    private final static String USER = "root";
    private final static String PASS = "vfnth";

    public static void main(String[] args) {
        boolean exit = false;
        System.setProperty("com.mysql.jdbc.Driver", "/home/aleksandr/Java/mysqldriver/mysql-connector-java-5.1.46/mysql-connector-java-5.1.46-bin");
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement statement = connection.createStatement()){
                statement.execute(SQLUtils.createUserTable());
                statement.execute(SQLUtils.createFotoTable());
                statement.execute(SQLUtils.createCommentsTable());
                statement.execute(SQLUtils.createLikesTable());
                statement.execute(SQLUtils.insertUsrData());
                statement.execute(SQLUtils.insertFotoData());
                statement.execute(SQLUtils.insertCommData());
                do{

                    switch (LikeMaker.makeChoice()){
                        case 0:
                            exit = true;
                            SQLUtils.closeScaner();
                            break;
                        case 1:
                            //Add new entity
                            statement.execute(SQLUtils.addEntity());
                            break;
                        case 2:
                            //Add like to user
                            try{
                                statement.execute(SQLUtils.addLike());
                            }catch (MySQLIntegrityConstraintViolationException e){
                                System.out.println("Repeated like");
                                System.out.println();
                            }
                            break;
                        case 3:
                            //Cancel a like
                            printLikesResult(statement.executeQuery(SQLUtils.showCurrentUsrLikes()));
                            statement.execute(SQLUtils.cancelLike());
                            break;
                        case 4:
                            //Show users made likes
                            printResult(statement.executeQuery(SQLUtils.showUsersMadeLikes()));
                            System.out.println();
                            break;
                        case 5:
                            //Show entity likes
                            printResult(statement.executeQuery(SQLUtils.showEntityLikes()));
                            break;
                        case 6:
                            //Show user likes
                            printLikesResult(statement.executeQuery(SQLUtils.showCurrentUsrLikes()));
                            System.out.println();
                    }

                }while (!exit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void printLikesResult(ResultSet result) throws SQLException {
        ArrayList<String> entNames = SQLUtils.getEntNames();
        while (result.next()){
            System.out.print("like_id: "+result.getString(1)+"; ");
            System.out.print("usr_id: "+result.getString(2)+"; ");
            for(int i = 0; i<entNames.size();i++){
                System.out.print(entNames.get(i)+" "+result.getString(i+3)+"; ");
            }
            System.out.print("status: "+result.getString(3+entNames.size())+";");
            System.out.println();
        }
    }
    private static void printResult(ResultSet result) throws SQLException {
        while (result.next()){
            System.out.println(result.getString(1));
        }
    }
}
