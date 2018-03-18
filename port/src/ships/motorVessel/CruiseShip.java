package ships.motorVessel;

public class CruiseShip extends MotorVessel{
    private int sleepers;

    public CruiseShip(String name, int sleepers, double diesel, double carrying) {
        super(diesel, carrying);
        this.name = name;
        this.sleepers = sleepers;
    }
    public void transportPassengers(){
        System.out.println("Перевозим пассажиров");
    }
    public void transportPassengers(Object animal, Object human){
        System.out.println("Перевозим только людей (животные плывут следом за бортом:)) ");
    }

    public int getSleepers() {
        return sleepers;
    }

    public void setSleepers(int sleepers) {
        this.sleepers = sleepers;
    }
    public void printFields(){
        System.out.println("Name: "+ name);
        System.out.println("Carrying: "+ carrying);
        System.out.println("Speed: "+ speed);
        System.out.println("IsMotor: "+ isMotor);
        System.out.println("Diesel: "+ diesel);
        System.out.println("Sleepers: "+ sleepers);
    }
}
