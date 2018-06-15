package low_cost.dijkstra;

import low_cost.entities.City;
import low_cost.entities.Track;

import java.util.ArrayList;

public class Dijkstra {
    private static final int MAX_COST = 200001;
    private City[] cities;
    private int startCityId;
    private int endCityId;

    public Dijkstra(City[] cities, int startCityId, int endCityId) {
        this.cities = cities;
        this.startCityId = startCityId;
        this.endCityId = endCityId;
    }

    /**
     * Method calculates and
     * @return the cheapest cost of a way
     */
    public int calculate() {
        //set all cities not visited
        setAllCitiesNotVisited();
        //set start city
        setStartCity(cities[startCityId]);
        //set max value for others cities
        setCostForOthersCities(startCityId);
        //set the cheapest way's cost for each neighbour's city
        while (hasNotVisitedCities()){
            setNeighboursCost(getCityWithCheapestCost());
        }
        //return the cheapest cost of a way
        return cities[endCityId].getCost();
    }

    private static void setStartCity(City startCity){
        //set start city way's cost to 0
        startCity.setCost(0);
    }

    //set max value for each city excluding start city
    private void setCostForOthersCities(int startCityId){
        for (int i = 1; i<cities.length;i++) {
            if (i!=startCityId){
                cities[i].setCost(MAX_COST);
            }
        }
    }

    //set the cheapest value for each neighbour's city
    private void setNeighboursCost(City thisCity){
        City neighbour;
        int sum;
        ArrayList<Track> tracks = thisCity.getTracks();
        if (tracks!=null){
            for (Track track: tracks) {
                sum = thisCity.getCost() + track.getCost();
                neighbour = cities[track.getEndCityId()];
                if(neighbour.getCost()>sum) {
                    neighbour.setCost(sum);
                }
            }
        }
        thisCity.setVisited(true);
    }

    /**
     * Method checks if cities have not visited
     */
    private boolean hasNotVisitedCities(){
        for (int i = 1; i<cities.length;i++) {
            if (!cities[i].isVisited()){
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks cities and
     * @return city with cheapest cost
     */
    private City getCityWithCheapestCost(){
        int cost = MAX_COST;
        City resultCity = null;
        City tempCity;
        for (int i = 1; i < cities.length; i++) {
            tempCity = cities[i];
            if (!tempCity.isVisited()&&cost>tempCity.getCost()){
                cost = tempCity.getCost();
                resultCity = tempCity;
            }
        }
        return resultCity;
    }
    //set all cities not visited
    private void setAllCitiesNotVisited(){
        for (int i = 1; i < cities.length; i++) {
            cities[i].setVisited(false);
        }
    }
}
