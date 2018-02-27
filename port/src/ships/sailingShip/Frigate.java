package ships.sailingShip;

public class Frigate extends SailingShip{
    private int cannonCount = 20;

    public Frigate(int sailCount, double speed, int cannonCount) {
        super(sailCount, speed);
        this.cannonCount = cannonCount;
    }

    public Frigate(double speed, int x, int y, int cannonCount) {
        super(speed, x, y);
        this.cannonCount = cannonCount;
    }

    public void shoot(Object object){
        System.out.println("Стреляем по объекту");

    }
}
