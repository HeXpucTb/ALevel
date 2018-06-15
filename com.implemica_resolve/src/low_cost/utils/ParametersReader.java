package low_cost.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ParametersReader {
    private static final String SELECT_SOURCE_MESSAGE = "Enter source you want to use (file or console allowed now):";
    private static final String FILE_CHOICE = "file";
    private static final String CONSOLE_CHOICE = "console";
    private static final String WRONG_CHOICE_MESSAGE = "wrong choice, try again";
    private static final String ENTER_PATH_MESSAGE = "Enter a path of file with parameters:";
    private static final String WRONG_PATH_MESSAGE = "Wrong path, try again:";

    /**
     * Method selects data source, read data and
     * @return string list
     */
    public static ArrayList<String> getParameters(){
        ArrayList<String> resultList = null;
        switch (selectDataSource()){
            case FILE_CHOICE:{
                resultList =  getDataFromFile();
                break;
            }
            case CONSOLE_CHOICE:{
                resultList = getDataFromConsole();
                break;
            }
        }
        return resultList;
    }

    /**
     * Method asks data source to user and
     * @return choice
     */
    private static String selectDataSource(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(SELECT_SOURCE_MESSAGE);
        String choice = scanner.nextLine();
        if(choice.equals(FILE_CHOICE)||choice.equals(CONSOLE_CHOICE)){
            return choice;
        }
        System.out.println(WRONG_CHOICE_MESSAGE);
        return selectDataSource();
    }

    /**
     * Method gets data from console and
     * @return string list
     */
    private static ArrayList<String> getDataFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String line;
        ArrayList<String> resultsList = new ArrayList<>();
        while ((line = scanner.nextLine())!=null){
            resultsList.add(line);
        }
        return resultsList;
    }

    /**
     * Method gets data from file and
     * @return string list
     */
    private static ArrayList<String> getDataFromFile(){
        ArrayList<String> resultList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(getFilePath() ))){
            String line;
            while ((line = reader.readLine())!=null) {
                resultList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Method asks file's path for reading data and
     * @return it
     */
    private static File getFilePath(){
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_PATH_MESSAGE);
        File file = new File(sc.nextLine());
        if(file.isFile()){
            return file;
        }
        System.out.println(WRONG_PATH_MESSAGE);
        return getFilePath();
    }
}
