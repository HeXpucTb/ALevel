package file_creator;

import initialize.FileExamp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCreator {
    public void createFile(String fileLoc, List<FileExamp> fileExamps) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileLoc))){
            List <String> list = convertToStringList(fileExamps);
            for (String ex: list) {
                writer.write(ex+System.lineSeparator());
                writer.flush();
            }

        }catch (IOException e){
            System.out.println("Файл не создан");
        }
    }
    private List<String> convertToStringList(List<FileExamp> fileExamps){
        List<String> fileToString = new ArrayList<>();
        for (FileExamp file: fileExamps) {
            String t = ""+file.getName()+" : "+file.getDateEx();
            fileToString.add(t);
        }
        return fileToString;
    }
}
