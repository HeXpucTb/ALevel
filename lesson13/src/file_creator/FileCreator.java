package file_creator;

import initialize.FileExamp;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileCreator {
    public void createFile(String fileLoc, List<FileExamp> fileExamps) {
        try {
            Files.write(Paths.get(fileLoc),convertToStringList(fileExamps));
        }catch (IOException e){
            System.out.println("Файл не создан");
        }
    }
    private List<String> convertToStringList(List<FileExamp> fileExamps){
        List<String> fileToString = new ArrayList<>();
        for (FileExamp file: fileExamps) {
            String t = ""+file.getPathLoc()+" : "+file.getDateEx();
            fileToString.add(t);
        }
        return fileToString;
    }
}
