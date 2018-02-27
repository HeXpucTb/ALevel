package ships.motorVessel;

import ships.Ship;

public class MotorVessel extends Ship {
    public boolean isMotor = true;
    public double diesel;

    public MotorVessel(double diesel, double carrying) {
        super.carrying = carrying;
        this.diesel = diesel;
    }

    @Override
    public void swim(int coordX, int coordY){
        System.out.println("Плывем пока есть горючее");
    }
}
