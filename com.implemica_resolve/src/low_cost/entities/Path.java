package low_cost.entities;

/**
 * Object of the class stores start and end points of a way
 */
public class Path {
    private int startCityId;
    private int endCityId;

    public Path(int startCityId, int endCityId) {
        this.startCityId = startCityId;
        this.endCityId = endCityId;
    }

    public int getStartCityId() {
        return startCityId;
    }

    public int getEndCityId() {
        return endCityId;
    }
}
