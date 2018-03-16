package initialize;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SimpFileVisitor extends SimpleFileVisitor<Path> {

    private String spaces = "";
    private List<String> filesList = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs){
        String name;
        String modDate;

        if(attrs.isRegularFile()||attrs.isSymbolicLink()){
            name = path.getFileName().toString();
            modDate = attrs.lastModifiedTime().toString();
            filesList.add(spaces+name+" : "+modDate);
        }
        return CONTINUE;

    }

    private void setSpaces(String spaces) {
        this.spaces = spaces;
    }

    private String getSpaces() {
        return spaces;
    }

    public List<String> getFilesList() {
        return filesList;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException e) {
        setSpaces(getSpaces().substring(1));
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException e){
        filesList.add(path.toString()+" "+e);
        return CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
        setSpaces(getSpaces()+" ");
        return CONTINUE;
    }
}
