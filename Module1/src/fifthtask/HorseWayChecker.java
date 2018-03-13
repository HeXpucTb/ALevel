package fifthtask;

import java.util.Scanner;

public class HorseWayChecker {
    private Scanner scanner = new Scanner(System.in);
    public void runHorseWayChecker(){
        Position currentPosition = initPosition();
        Position nextPosition = initPosition();
        if(checkPossibilityToGo(currentPosition,nextPosition)){
            System.out.println("Ход возможен");
        }else {
            System.out.println("Так ходить нельзя");
        }
    }
    private Position initPosition(){
        System.out.println("Введите позицию:");
        System.out.println("По Х:");
        int x = scanner.nextInt();
        System.out.println("по У (1 - a, 2 - b, 3 - c, 4 - d, 5 - e, 6 - f, 7 - g, 8 - h):");
        char y =(char)(96 + scanner.nextInt());
        if ((x>0&&x<9)&&((int)y>96&&(int)y<105)) {
            return new Position(x,y);
        }else {
            System.out.println("Некорректная позиция");
            return initPosition();
        }
    }
    private boolean checkPossibilityToGo(Position start, Position next){
        int sX = start.getCurrentX();
        char sY = start.getCurrentY();
        int nX = next.getCurrentX();
        char nY = next.getCurrentY();
        return  ((Math.abs(sX-nX)==1)&&(Math.abs((int)sY-(int)nY)==2)||(Math.abs(sX-nX)==2)&&(Math.abs((int)sY-(int)nY)==1));
    }
}
