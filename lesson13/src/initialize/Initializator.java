package initialize;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Initializator {
    private List<String> fileExamps;
    private Scanner scanner;

    public Initializator() {
        this.fileExamps = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public FileExamp initFile(){
        System.out.println("Введите путь к файлу:");
        Path path = Paths.get(scanner.nextLine());
        System.out.println("Введите имя файла:");
        String name = scanner.nextLine();
        FileExamp fileExamp = new FileExamp(path, name);
        fileExamp.setPathLoc(path);
        return fileExamp;
    }
    public File initPath(){
        System.out.println("Введите путь к директории:");
        return new File(scanner.nextLine());
    }
    public void getContent(File dir, String spaces){
        if(dir.isFile()&&dir.canRead()){
            Date lastMod = new Date(dir.lastModified());
            //Path dirPath = Paths.get(dir.getAbsolutePath());
            //FileExamp fileExamp = new FileExamp(dirPath, spaces+dir.getName(), lastMod);
            fileExamps.add(""+dir.getName()+" : "+lastMod);
        }
        else {
            spaces +="  ";
            File[] subDir = dir.listFiles();
            if(subDir!=null) {
                for (File sub : subDir) {
                    if(sub.isFile()&&sub.canRead()){
                        Date lastMod = new Date(sub.lastModified());
                        //Path dirPath = Paths.get(sub.getAbsolutePath());
                        //FileExamp fileExamp = new FileExamp(dirPath, spaces+sub.getName(), lastMod);
                        fileExamps.add(spaces+sub.getName()+" : "+lastMod);
                    }
                    if (sub.listFiles() != null&&sub.canRead()) {
                        getContent(sub, spaces);
                    }
                }
            }
        }
    }
    public void getContentByVisitor(Path path){

        SimpFileVisitor fileVisitor = new SimpFileVisitor();
        EnumSet<FileVisitOption> options =  EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        int maxDepth = 100000;
        try{
            Files.walkFileTree(path,options, maxDepth, fileVisitor);
            this.fileExamps = fileVisitor.getFilesList();
        }catch (IOException e){
            System.out.println("ошибка ввода-вывода");
        }
    }
    public List<String> getFileExamps() {
        return fileExamps;
    }
}
