package low_cost.entities;

/**
 * Object of the class stores parameters for track
 */
public class Track {
    private int endCityId;
    private int cost;
    public Track(int endCityId, int cost){
        this.endCityId = endCityId;
        this.cost = cost;
    }

    public int getEndCityId() {
        return endCityId;
    }

    public int getCost() {
        return cost;
    }
}
