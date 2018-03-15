package initialize;

import java.util.Date;

public class FileExamp {
    private Date dateEx;
    private String pathLoc;
    private String name;

    public Date getDateEx() {
        return dateEx;
    }

    public String getPathLoc() {
        return pathLoc;
    }

    public void setPathLoc(String pathLoc) {
        this.pathLoc = pathLoc;
    }

    public FileExamp(String pathLoc, String name, Date dateEx) {
        this.dateEx = dateEx;
        this.pathLoc = pathLoc;
        this.name = name;
    }
    public FileExamp(String pathLoc, String name){
        this.pathLoc = pathLoc;
        this.dateEx = new Date();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
