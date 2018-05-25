package console_editor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileUtils {
    private static String filePath;
    private static final String GET_FILEPATH_TEXT = "Enter filename:";
    private static final String TEMP_FILEPATH = "/home/aleksandr/temptest.txt";
    public static void saveDataToFile(ArrayList<String> text){
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(filePath))){
            for (String str: text) {
                wr.write(str+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void updateDataAtFile(ArrayList<String> text){
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(filePath,true))){
            for (String str: text) {
                wr.write(str+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> getDataFromFile(){
        ArrayList<String> tempText = new ArrayList<>();
        String currentLine;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((currentLine=reader.readLine())!=null){
                tempText.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempText;
    }
    private static String getFilePath(){
        Scanner sc = new Scanner(System.in);
        boolean agree = false;
        String tempFilePath;
        do{
            System.out.println(GET_FILEPATH_TEXT);
            tempFilePath = sc.nextLine();
            filePath = tempFilePath;
            if(filePath.equals("")){
                filePath = TEMP_FILEPATH;
                tempFilePath = TEMP_FILEPATH;
            }
            System.out.println("changed file: "+filePath);
            System.out.println("Enter 'y' if you agree");
            if(sc.nextLine().equals("y")){
                agree = true;
            }
        }while (!agree);
        return tempFilePath;
    }
    public static boolean isFileExists(){
        return Files.exists(Paths.get(getFilePath()));
    }
}
