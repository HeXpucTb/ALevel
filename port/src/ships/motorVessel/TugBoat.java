package ships.motorVessel;

import ships.Ship;

public class TugBoat extends MotorVessel{
    private int power;
    public void towShip(Ship ship){
        System.out.println("Тянем корабль");
    }
    public void towShip(CruiseShip ship){
        System.out.println("Тянем круизный лайнер");
    }
    public TugBoat(String name, int power, double diesel, double carrying) {
        super(diesel,carrying);
        this.name = name;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public void printFields(){
        System.out.println("Name: "+ name);
        System.out.println("Carrying: "+ carrying);
        System.out.println("Speed: "+ speed);
        System.out.println("IsMotor: "+ isMotor);
        System.out.println("Diesel: "+ diesel);
        System.out.println("Power: "+ power);
    }
}
