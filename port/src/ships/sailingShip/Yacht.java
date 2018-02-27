package ships.sailingShip;

public class Yacht extends SailingShip{
    private int chairs = 10;
    private String sailForm = "Triangle";

    public Yacht(int chairs, String sailForm, int sailCount, double speed) {
        super(sailCount, speed);
        this.chairs = chairs;
        this.sailForm = sailForm;
    }
    public Yacht(int chairs, int sailCount, double speed){
        super(sailCount,speed);

        this.chairs = chairs;
    }
}
