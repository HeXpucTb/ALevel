package initialize;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Initializator {
    private List<FileExamp> fileExamps;
    private Scanner scanner;

    public Initializator() {
        this.fileExamps = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public FileExamp initFile(){
        System.out.println("Введите путь к файлу:");
        String path = scanner.nextLine();
        System.out.println("Введите имя файла:");
        String name = scanner.nextLine();
        FileExamp fileExamp = new FileExamp(path, name);
        fileExamp.setPathLoc(path+name);
        return fileExamp;
    }
    public File initPath(){
        System.out.println("Введите путь к директории:");
        return new File(scanner.nextLine());
    }
    public void getContent(File dir, String spaces){
        if(dir.isFile()){
            Date lastMod = new Date(dir.lastModified());
            FileExamp fileExamp = new FileExamp(spaces+dir.getAbsolutePath(), dir.getName(), lastMod);
            fileExamps.add(fileExamp);
        }
        else {
            spaces +=" ";
            File[] subDir = dir.listFiles();
            if(subDir!=null) {
                for (File sub : subDir) {
                    if(sub.isFile()){
                        Date lastMod = new Date(dir.lastModified());
                        FileExamp fileExamp = new FileExamp(spaces+sub.getAbsolutePath(), sub.getName(), lastMod);
                        fileExamps.add(fileExamp);
                    }
                    if (sub.listFiles() != null) {
                        getContent(sub, spaces);
                    }
                }
            }
        }
    }

    public List<FileExamp> getFileExamps() {
        return fileExamps;
    }
}
