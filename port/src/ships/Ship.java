package ships;

public class Ship {
    public double carrying;
    public double speed;

    public void swim(int coordX, int coordY){
        System.out.println("Плыть в точку "+coordX+","+coordY);
    }
}
