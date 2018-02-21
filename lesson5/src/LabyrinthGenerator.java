import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LabyrinthGenerator {
    private int[][] labyrinth;
    private int[][] allMoves;
    private int[][] shortWay;
    private int[] enter;
    private int[] exit;
    private int countMoves = 0;
    private int currentX = 1;
    private int currentY = 1;
    private int endLabX;
    private int endLabY;
    private int neighborXU;
    private int neighborXD;
    private int neighborYL;
    private int neighborYR;
    private int temp;
    private int startSteps;
    private int allSteps;
    private boolean neighborDown;
    private boolean neighborUp;
    private boolean neighborLeft;
    private boolean neighborRight;

    public void callLabyrinthResolve(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество ячеек для стороны лабиринта:");
        int n = in.nextInt();
        if (n%2==0){
            n++;
        }
        endLabX = n-1;
        endLabY = n-1;
        allMoves = new int[n*n/2][2];

        initializeLabyrinth(n);
        generateLabyrinth();
        setEnter();
        setExit();
        findExit();
        printShortWay();
        resetLab();
        printMatrix(labyrinth);
    }
    public void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    private void initializeLabyrinth(int n){
        labyrinth = new int[n][n];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((i%2!=0)&&(j%2!=0)&&((i<n-1)&&(j<n-1))){
                    labyrinth[i][j] = 0;
                }
                else {
                    labyrinth[i][j] = 1;
                }
            }
        }
    }
    private void generateLabyrinth(){
        doFirstWay();
        doOtherWays();
    }
    private void doFirstWay(){
        Random random = new Random();
        do {
            int nextStep = random.nextInt(4) + 1;
            switch (nextStep) {
                case 1: {
                    removeWallUp();
                    break;
                }
                case 2: {
                    removeWallDown();
                    break;
                }
                case 3: {
                    removeWallRight();
                    break;
                }
                case 4: {
                    removeWallLeft();
                    break;
                }
            }
        }while (((currentX+currentY)<(endLabY-1)+(endLabX-1))&&(!checkDeadLock()));
        labyrinth[currentX][currentY] = 2;
    }
    private void removeWallUp(){
        if (currentX > 2) {
            if(!checkDeadLock()) {
                temp = labyrinth[neighborXU][currentY];
                if (temp == 0) {
                    labyrinth[currentX][currentY] = 2;
                    labyrinth[--currentX][currentY] = 2;
                    --currentX;
                    allMoves[countMoves][0] = currentX;
                    allMoves[countMoves][1] = currentY;
                    countMoves++;
                }
            }
        }
    }
    private void removeWallDown(){
        if (currentX < endLabX - 2) {
            if(!checkDeadLock()) {
                temp = labyrinth[neighborXD][currentY];
                if (temp == 0) {
                    labyrinth[currentX][currentY] = 2;
                    labyrinth[++currentX][currentY] = 2;
                    ++currentX;
                    allMoves[countMoves][0] = currentX;
                    allMoves[countMoves][1] = currentY;
                    countMoves++;
                }
            }
        }
    }
    private void removeWallRight(){
       if (currentY < endLabY - 2) {
            if(!checkDeadLock()) {
                temp = labyrinth[currentX][neighborYR];
                if (temp == 0) {
                    labyrinth[currentX][currentY] = 2;
                    labyrinth[currentX][++currentY] = 2;
                    ++currentY;
                    allMoves[countMoves][0] = currentX;
                    allMoves[countMoves][1] = currentY;
                    countMoves++;
                }
            }
        }
    }
    private void removeWallLeft(){
        if (currentY > 2) {
            if(!checkDeadLock()) {
                temp = labyrinth[currentX][neighborYL];
                if (temp == 0) {
                    labyrinth[currentX][currentY] = 2;
                    labyrinth[currentX][--currentY] = 2;
                    --currentY;
                    allMoves[countMoves][0] = currentX;
                    allMoves[countMoves][1] = currentY;
                    countMoves++;
                }
            }
        }
    }
    private void doOtherWays(){
        //Возможно переделать под обратную проверку или под рандом
        for(int i = 0; (allMoves[i][0]>0)||(allMoves[i][1]>0);i++){
            currentX = allMoves[i][0];
            currentY = allMoves[i][1];
            if(!checkDeadLock()) {
                doFirstWay();
            }
        }
    }
    private void setEnter(){
        int x = 0;
        int y = 1;
        /*Scanner in = new Scanner(System.in);
        System.out.println("Введите координату входа X:");
        int x = in.nextInt();
        System.out.println("Введите координату входа У:");
        int y = in.nextInt();*/
        enter = new int[2];
        enter[0] = x;
        enter[1] = y;
        labyrinth[x][y] = 2;
    }
    private void setExit(){
        int x = endLabX;
        int y = endLabY-1;

        /*Scanner in = new Scanner(System.in);
        System.out.println("Введите координату выхода X:");
        int x = in.nextInt();
        System.out.println("Введите координату выхода У:");
        int y = in.nextInt();*/
        exit = new int[2];
        exit[0] = x;
        exit[1] = y;
        labyrinth[x][y] = 2;
    }
    private boolean checkDeadLock(){
        boolean outOfUp = currentX<3;
        boolean outOfDown = currentX>endLabX-2;
        boolean outOfRight = currentY>endLabY-2;
        boolean outOfLeft = currentY<3;

        if(!outOfLeft) {
            neighborYL = currentY - 2;
            neighborLeft = labyrinth[currentX][neighborYL]==2;
        }
        if(!outOfRight) {
            neighborYR = currentY + 2;
            neighborRight = labyrinth[currentX][neighborYR]==2;
        }
        if(!outOfUp) {
            neighborXU = currentX - 2;
            neighborUp = labyrinth[neighborXU][currentY]==2;
        }
        if(!outOfDown) {
            neighborXD = currentX + 2;
            neighborDown = labyrinth[neighborXD][currentY]==2;
        }
        return (((neighborRight)||outOfRight)&&((neighborLeft)||outOfLeft)&&((neighborUp)||outOfUp)&&((neighborDown)||outOfDown));
    }

    private void findExit(){
        currentX = enter[0];
        currentY = enter[1];
        shortWay = new int[allMoves.length][5];
        shortWay[0][0] = currentX;
        shortWay[0][1] = currentY;
        shortWay[0][3] = 1;
        shortWay[0][4] = allSteps++;
        labyrinth[currentX][currentY] = 3;
        currentX = 1;
        currentY = 1;
        checkBranch();
        labyrinth[currentX][currentY] = 3;
        shortWay[allSteps][0] = currentX;
        shortWay[allSteps][1] = currentY;
        shortWay[allSteps][3] = 1;
        shortWay[allSteps][4] = ++allSteps;
    }
    private void checkNeighbors(){
        neighborYL = currentY - 1;
        neighborLeft = labyrinth[currentX][neighborYL]==2;
        neighborYR = currentY + 1;
        neighborRight = labyrinth[currentX][neighborYR]==2;
        neighborXU = currentX - 1;
        neighborUp = labyrinth[neighborXU][currentY]==2;
        neighborXD = currentX + 1;
        neighborDown = labyrinth[neighborXD][currentY]==2;
    }
    private void goUp(){
        shortWay[allSteps][2]++;
        if(neighborRight||neighborLeft||neighborDown){
            shortWay[allSteps][2]++;
        }
        labyrinth[currentX][currentY] = 3;
        shortWay[allSteps][0] = currentX;
        shortWay[allSteps][1] = currentY;
        currentX--;
        shortWay[allSteps][3] = 1;
        shortWay[allSteps][4] = allSteps;
        allSteps++;
    }
    private void goDown(){
        shortWay[allSteps][2]++;
        if(neighborRight||neighborLeft||neighborUp){
            shortWay[allSteps][2]++;
        }
        labyrinth[currentX][currentY] = 3;
        shortWay[allSteps][0] = currentX;
        shortWay[allSteps][1] = currentY;
        currentX++;
        shortWay[allSteps][3] = 1;
        shortWay[allSteps][4] = allSteps;
        allSteps++;
    }
    private void goLeft(){
        shortWay[allSteps][2]++;
        if(neighborRight||neighborUp||neighborDown){
            shortWay[allSteps][2]++;
        }
        labyrinth[currentX][currentY] = 3;
        shortWay[allSteps][0] = currentX;
        shortWay[allSteps][1] = currentY;
        currentY--;
        shortWay[allSteps][3] = 1;
        shortWay[allSteps][4] = allSteps;
        allSteps++;
    }
    private void goRight(){
        shortWay[allSteps][2]++;
        if(neighborUp||neighborLeft||neighborDown){
            shortWay[allSteps][2]++;
        }
        labyrinth[currentX][currentY] = 3;
        shortWay[allSteps][0] = currentX;
        shortWay[allSteps][1] = currentY;
        currentY++;
        shortWay[allSteps][3] = 1;
        shortWay[allSteps][4] = allSteps;
        allSteps++;
    }
    private void findNewBranch(){
        for(int i = allSteps; i>0;i--){
            if (shortWay[i][2]>1){
                startSteps = shortWay[i][4];
                markAsWrong();
                shortWay[i][2]-=3;
                shortWay[i][3] = 5;
                currentX = shortWay[i][0];
                currentY = shortWay[i][1];
                checkBranch();
                return;
            }
        }
    }
    private void checkBranch(){
        while (!((currentX==exit[0])&&(currentY==exit[1]))){
            checkNeighbors();
            if (neighborUp) {
                goUp();
            }
            else if (neighborDown) {
                goDown();
            }
            else if (neighborLeft) {
                goLeft();
            }
            else if (neighborRight) {
                goRight();
            }
            //Тупик
            if ((!neighborUp) && (!neighborDown) && (!neighborLeft) && (!neighborRight)) {
                labyrinth[currentX][currentY] = 3;
                findNewBranch();
            }
        }
    }
    private void markAsWrong(){
        for (int i = allSteps;i>=startSteps;i--){
            if(shortWay[i][2]<0){
                shortWay[i][3] = 5;
                return;
            }
            shortWay[i][3] = 5;
        }
    }
    private void printShortWay(){
        int steps = 0;
        System.out.println("Кратчайший путь:");
        for(int i = 0; i < 2;i++){
            for(int j = 0; j<shortWay.length;j++){
                if(shortWay[j][3]==1) {
                    steps++;
                    if(shortWay[j][i]/10>0) {
                        System.out.print(" " + shortWay[j][i]);
                    }
                    if(shortWay[j][i]/10 ==0){
                        System.out.print("  " + shortWay[j][i]);
                    }
                }
            }
            System.out.println();
        }
        System.out.println("Наименьшее количество ходов для выхода - "+steps/2);
    }
    private void resetLab(){
        for(int i = 0; i <labyrinth.length;i++){
            for(int j = 0; j<labyrinth[i].length;j++){
                if(labyrinth[i][j]==2||labyrinth[i][j]==3){
                    labyrinth[i][j] = 0;
                }
            }
        }
    }
}
