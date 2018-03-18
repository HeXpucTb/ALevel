package ships;

import ships.motorVessel.CruiseShip;
import ships.motorVessel.TugBoat;
import ships.sailingShip.Frigate;
import ships.sailingShip.Yacht;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    private static List<Ship> shipList;
    public static void main(String[] args) {
        Path path = initPath();
        File file = new File(path.toString());
        ObjectWrapper wrapper = new ObjectWrapper(path);
        if(file.exists()){
            shipList = wrapper.fileRead();
        }else {
            shipList = initShips();
            wrapper.fileWrite(shipList = initShips());
        }
        printShips();
    }

    private static List<Ship> initShips(){
        List<Ship> ships = new ArrayList<>();
        ships.add(new CruiseShip("McAlister",50,350.5,5000.0));
        ships.add(new TugBoat("BlackBull",300, 1000.0, 500.0));
        ships.add(new Frigate("St.Maria",20,30.0,50));
        ships.add(new Yacht("NightBreeze",25, "Triangle", 1, 50));
        ships.add(new Frigate("BlackPerl",20,60,15));
        return ships;
    }
    private static Path initPath(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write full path to file");
        return Paths.get(scanner.nextLine());
    }
    private static void printShips(){
        for (Ship s: shipList) {
            System.out.println(s.toString());
            s.printFields();
            System.out.println();
        }
    }
}
