import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo {
    public static String read(String path) {
        StringBuilder stringBuilder = null;

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            stringBuilder = new StringBuilder();
            String currentString = reader.readLine();
            while (currentString != null) {
                stringBuilder.append(currentString);
                stringBuilder.append("\n");
            }
        }
        catch (IOException e) {
            System.out.println("Ничего не передано в currentString");
        }

        return stringBuilder.toString();
    }
    public static void main (String[]args){
            System.out.println(read("/home/aleksandr/IdeaProjects/ALevel/com.demoLesson9/test.txt"));
    }
}
