
import file_creator.FileCreator;
import initialize.FileExamp;
import initialize.Initializator;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        FileCreator fileCreator = new FileCreator();
        Initializator initializator = new Initializator();
        File path = initializator.initPath();
        FileExamp fileContainer = initializator.initFile();
        initializator.getContent(path,"");
        fileCreator.createFile(fileContainer.getPathLoc(), initializator.getFileExamps());

        //При желании распечатать файл - раскомментируйте строку ниже
        //printFile(fileContainer.getPathLoc());
    }
    private static void printFile(String fileLoc){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileLoc))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
