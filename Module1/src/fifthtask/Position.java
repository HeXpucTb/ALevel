package fifthtask;

public class Position {
    private int currentX;
    private char currentY;
    public Position(int x,char y){
        this.currentX = x;
        this.currentY = y;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public char getCurrentY() {
        return currentY;
    }

    public void setCurrentY(char currentY) {
        this.currentY = currentY;
    }
}
