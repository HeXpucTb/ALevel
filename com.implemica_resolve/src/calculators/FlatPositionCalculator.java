package calculators;

import java.util.Scanner;

public class FlatPositionCalculator {
    private int floors;
    private int flats;
    private int flatNum;
    public void run(){
        initParameters();
        int enter = flatNum/(floors*flats);
        if (flatNum%(floors*flats)!=0) ++enter;
        int floor = (flatNum%(floors*flats))/flats;
        if (((flatNum%(floors*flats))%flats)!=0) ++floor;
        if (floor==0) floor = floors;
        System.out.println("Flat "+flatNum+" at "+enter+" enter, at "+floor+" floor");
    }
    private void initParameters(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter floor count:");
        floors = sc.nextInt();
        System.out.println("Enter flat count:");
        flats = sc.nextInt();
        System.out.println("Enter flat number:");
        flatNum = sc.nextInt();
    }
}
