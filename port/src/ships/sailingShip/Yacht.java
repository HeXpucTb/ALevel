package ships.sailingShip;

public class Yacht extends SailingShip {
    private int chairs = 10;
    private String sailForm = "Triangle";

    public Yacht(String name, int chairs, String sailForm, int sailCount, double speed) {
        super(sailCount, speed);
        this.name = name;
        this.chairs = chairs;
        this.sailForm = sailForm;
    }
    public Yacht(String name, int sailCount, double speed){
        super(sailCount,speed);
        this.name = name;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public String getSailForm() {
        return sailForm;
    }

    public void setSailForm(String sailForm) {
        this.sailForm = sailForm;
    }
    public void printFields(){
        System.out.println("Name: "+ name);
        System.out.println("Carrying: "+ carrying);
        System.out.println("Speed: "+ speed);
        System.out.println("Sailcount: "+ sailCount);
        System.out.println("Chairs: "+ chairs);
        System.out.println("SailForm: "+ sailForm);
    }
}
