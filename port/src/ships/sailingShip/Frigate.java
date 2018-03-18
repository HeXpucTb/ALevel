package ships.sailingShip;

public class Frigate extends SailingShip {
    private int cannonCount = 20;

    public Frigate(String name, int sailCount, double speed, int cannonCount) {
        super(sailCount, speed);
        this.name = name;
        this.cannonCount = cannonCount;
    }

    public Frigate(String name, double speed, int x, int y, int cannonCount) {
        super(speed, x, y);
        this.name = name;
        this.cannonCount = cannonCount;
    }

    public void shoot(Object object){
        System.out.println("Стреляем по объекту");

    }

    public int getCannonCount() {
        return cannonCount;
    }

    public void setCannonCount(int cannonCount) {
        this.cannonCount = cannonCount;
    }
    public void printFields(){
        System.out.println("Name: "+ name);
        System.out.println("Carrying: "+ carrying);
        System.out.println("Speed: "+ speed);
        System.out.println("Sailcount: "+ sailCount);
        System.out.println("Cannoncount: "+ cannonCount);
    }
}
