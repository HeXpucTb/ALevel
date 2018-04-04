import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class FileUtils {
    public static ArrayList<String> readFile(String path){
        ArrayList<String> strings = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))){
            String line;
            while ((line = reader.readLine()) != null){
                strings.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        }

        return strings;
    }
    public static ArrayList<String> parseCsvString(String str){
        String str1 = str;
        ArrayList<String> csvStrings = new ArrayList<>();
        while (str1.contains(",")){
            int ind = str1.indexOf(",");
            csvStrings.add(str1.substring(0, ind));
            str1 = str1.substring(ind);
        }
        return csvStrings;
    }
    public static ArrayList<String> parseTxtString(String str){
        ArrayList<String> txtStrings = new ArrayList<>();
        return txtStrings;
    }
}
