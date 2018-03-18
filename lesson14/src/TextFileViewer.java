import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextFileViewer {

    public static void main(String[] args) {
        try{
            StringWrapper wrapper = new StringWrapper(initPath());
            for (String string: wrapper) {
                System.out.println(string);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private static Path initPath(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write file's path:");
        return Paths.get(scanner.nextLine());
    }
}
