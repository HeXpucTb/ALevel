public class Bet {
    private String humanName;
    private int horseNumber;
    private double volume;

    public Bet(String humanName, int horseNumber, double volume) {
        this.humanName = humanName;
        this.horseNumber = horseNumber;
        this.volume = volume;
    }

    public String getHumanName() {
        return humanName;
    }

    public int getHorseNumber() {
        return horseNumber;
    }

    public double getVolume() {
        return volume;
    }
}
