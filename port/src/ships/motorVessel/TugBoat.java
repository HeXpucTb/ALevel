package ships.motorVessel;

import ships.Ship;

public class TugBoat extends MotorVessel {
    private int power;
    public void towShip(Ship ship){
        System.out.println("Тянем корабль");
    }
    public void towShip(CruiseShip ship){
        System.out.println("Тянем круизный лайнер");
    }
    public TugBoat(int power, double diesel, double carrying) {
        super(diesel,carrying);
        this.power = power;
    }
}
