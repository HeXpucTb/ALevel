package ships.motorVessel;

import ships.Ship;

public abstract class MotorVessel extends Ship {
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
    public void printFields(){
        System.out.println("Name: "+ name);
        System.out.println("Carrying: "+ carrying);
        System.out.println("Speed: "+ speed);
        System.out.println("IsMotor: "+ isMotor);
        System.out.println("Diesel: "+ diesel);
    }
}
