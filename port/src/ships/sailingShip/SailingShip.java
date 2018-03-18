package ships.sailingShip;

import ships.Ship;

public abstract class SailingShip extends Ship {
    public int sailCount = 1;

    public SailingShip(int sailCount, double speed) {
        super.speed = speed;
        this.sailCount = sailCount;
    }
    public SailingShip(double speed, int x, int y){
        super.name = this.name;
        super.speed = speed;
        super.swim(x,y);
    }
    @Override
    public void swim(int coordX, int coordY){
        System.out.println("Плывем по ветру");
    }
    public void printFields(){
        System.out.println("Name: "+ name);
        System.out.println("Carrying: "+ carrying);
        System.out.println("Speed: "+ speed);
        System.out.println("Sailcount: "+ sailCount);
    }
}
