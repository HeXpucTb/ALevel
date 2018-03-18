package ships;

import java.io.Serializable;

public abstract class Ship implements Serializable{
    public String name;
    public double carrying;
    public double speed;

    public void swim(int coordX, int coordY){
        System.out.println("Плыть в точку "+coordX+","+coordY);
    }
    public void printFields(){
        System.out.println("Name: "+ name);
        System.out.println("Carrying: "+ carrying);
        System.out.println("Speed: "+ speed);
    }
}
