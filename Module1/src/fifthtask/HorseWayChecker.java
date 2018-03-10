package fifthtask;

import java.util.Scanner;

public class HorseWayChecker {
    private Position[][] chessDesk;
    private Scanner scanner = new Scanner(System.in);
    public void runHorseWayChecker(){
        initChessDesk();
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
            Position position = new Position(x, y);
            return position;
        }else {
            System.out.println("Некорректная позиция");
            return initPosition();
        }
    }
    private void initChessDesk(){
        chessDesk = new Position[8][8];
        char y = 'a';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Position deskField = new Position(j+1,y);
                chessDesk[i][j] = deskField;
            }
            y++;
        }
    }
    private boolean checkPossibilityToGo(Position start, Position next){
        int startX = start.getCurrentX();
        char startY = start.getCurrentY();
        int nextX = next.getCurrentX();
        char nextY = next.getCurrentY();
        if ((Math.abs(startX-nextX)==1)&&(Math.abs((int)startY-(int)nextY)==2)){
            return true;
        }
        if((Math.abs(startX-nextX)==2)&&(Math.abs((int)startY-(int)nextY)==1)){
            return true;
        }
        else return false;
    }
}
