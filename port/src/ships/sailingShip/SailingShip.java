package ships.sailingShip;

import ships.Ship;

public class SailingShip extends Ship {
    public int sailCount = 1;

    public SailingShip(int sailCount, double speed) {
        super.speed = speed;
        this.sailCount = sailCount;
    }
    public SailingShip(double speed, int x, int y){
        super.speed = speed;
        super.swim(x,y);
    }
    @Override
    public void swim(int coordX, int coordY){
        System.out.println("Плывем по ветру");
    }
}
