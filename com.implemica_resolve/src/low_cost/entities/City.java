package low_cost.entities;

import java.util.ArrayList;

/**
 * Object of the class stores parameters for a city
 */
public class City {
    private final String name;
    private final int id;
    private final ArrayList<Track> tracks;
    private boolean visited;
    private int cost;

    public City(String name, int id, ArrayList<Track> tracks){
        this.name = name;
        this.id = id;
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
