package initialize;

import java.nio.file.Path;
import java.util.Date;

public class FileExamp {
    private Date dateEx;
    private Path pathLoc;
    private String name;

    public Date getDateEx() {
        return dateEx;
    }

    public Path getPathLoc() {
        return pathLoc;
    }

    public void setPathLoc(Path pathLoc) {
        this.pathLoc = pathLoc;
    }

    public FileExamp(Path pathLoc, String name, Date dateEx) {
        this.dateEx = dateEx;
        this.pathLoc = pathLoc;
        this.name = name;
    }
    public FileExamp(Path pathLoc, String name){
        this.pathLoc = pathLoc;
        this.dateEx = new Date();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
