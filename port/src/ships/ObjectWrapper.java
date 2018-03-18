package ships;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ObjectWrapper{
    private Path path;
    public ObjectWrapper(Path path) {
        this.path = path;
    }

    public void fileWrite(List<Ship> ships){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toString()))){
            for (Ship ex: ships) {
                oos.writeObject(ex);
                oos.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<Ship> fileRead(){
        List<Ship> ships = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()))) {
            while (true) {
                try{
                    ships.add((Ship) ois.readObject());
                }catch (EOFException e){
                    break;
                }

            }
        }catch (ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
        return ships;
    }

}
