package ships.motorVessel;

public class CruiseShip extends MotorVessel {
    private int sleepers;

    public CruiseShip(int sleepers, double diesel, double carrying) {
        super(diesel, carrying);
        this.sleepers = sleepers;
    }
    public void transportPassengers(){
        System.out.println("Перевозим пассажиров");
    }
    public void transportPassengers(Object animal, Object human){
        System.out.println("Перевозим только людей (животные плывут следом за бортом:)) ");
    }
}
