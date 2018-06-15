package low_cost.entities;

import low_cost.dijkstra.Dijkstra;

import java.util.ArrayList;

public class Test {
    private int testId;
    private ArrayList<Integer> results;
    private ArrayList<Path> paths;
    private City[] cities;

    /**
     * Constructor for new test with parameters
     * @param testId
     * @param paths
     * @param cities
     */
    public Test(int testId, ArrayList<Path> paths, City[] cities) {
        this.testId = testId;
        this.paths = paths;
        this.cities = cities;
    }

    /**
     * Method prints results of the test
     */
    public void printTheTestResults(){
        System.out.println("Test id: "+testId);
        System.out.println("output:");
        for (Integer result: results) {
            System.out.println(result);
        }
        System.out.println();
    }

    /**
     * Method runs the test using Dijkstra algorithm
     * and save results to list
     */
    public void runTest() {
        results = new ArrayList<>();
        Dijkstra dijkstra;
        for (Path path : paths) {
            if (path != null) {
                //Send parameters to the dijkstra resolver
                dijkstra = new Dijkstra(cities, path.getStartCityId(), path.getEndCityId());
                results.add(dijkstra.calculate());
            }
        }
    }
}
