package com.utils;

import java.sql.*;
import java.util.ArrayList;

public abstract class DBHandler {
    private final static String URL = "jdbc:mysql://localhost:3306/webexcel";
    private final static String USER = "root";
    private final static String PASS = "vfnth";
    private final static String QUERY_GET_TABLES = "SHOW TABLES FROM webexcel";
    private final static String QUERY_DEL_TABLE = "DROP TABLE IF EXISTS ";
    private final static String QUERY_CREATE_TABLE_FIRST = "CREATE TABLE ";
    private final static String QUERY_CREATE_TABLE_SECOND = " (id INT AUTO_INCREMENT, labels VARCHAR(50) UNIQUE," +
                                                            " valuues VARCHAR(300), PRIMARY KEY (id));";
    private final static String QUERY_GET_VALUE_FROM_TABLE = "SELECT labels, valuues FROM ";
    private static ArrayList<Article> initGet(String query) {
        ArrayList<Article> ansList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement st = connection.createStatement()){
            ResultSet answer =  st.executeQuery(query);
            while (answer.next()){
                ansList.add(new Article(answer.getString(1),answer.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ansList;
    }
    private static void initPost(String query) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement st = connection.createStatement()){
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> getTables() throws SQLException {
        ArrayList<String> result = new ArrayList<>();
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try(Connection connection = DriverManager.getConnection(URL,USER, PASS);
            Statement st = connection.createStatement()){
            result = handleResult(st.executeQuery(QUERY_GET_TABLES));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void deleteTable(String tblname) throws SQLException {
        initPost(buildDeleteTableQuery(tblname));
    }
    public static void createTable(String tblname) throws SQLException{
        deleteTable(tblname);
        initPost(buildCreateTableQuery(tblname));
    }
    public static ArrayList<Article> getTablesFromDB(String tblname) throws SQLException{
        return initGet(buildGetTablesQuery(tblname));
    }
    public static void editTable(ArrayList<Article> articles,String tblname) throws SQLException {
        deleteTable(tblname);
        createTable(tblname);
        for (Article art: articles) {
            initPost(buildEditTableQuery(art, tblname));
        }
    }
    private static ArrayList<String> handleResult(ResultSet result) throws SQLException {
        ArrayList<String> ansList = new ArrayList<>();
        while (result.next()){
            ansList.add(result.getString(1));
        }
        return ansList;
    }
    private static String buildDeleteTableQuery(String tblName){
        return QUERY_DEL_TABLE+tblName;
    }
    private static String buildCreateTableQuery(String tblName){
        return QUERY_CREATE_TABLE_FIRST+tblName+QUERY_CREATE_TABLE_SECOND;
    }
    private static String buildGetTablesQuery(String tblName){
        return QUERY_GET_VALUE_FROM_TABLE +tblName;
    }
    private static String buildEditTableQuery(Article art, String tblName){
        return "INSERT INTO " + tblName + " (labels, valuues) VALUES('" + art.getIdEx() + "','" + art.getVall() + "');";
    }
}