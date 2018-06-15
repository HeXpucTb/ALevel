package low_cost;

import low_cost.containers.*;
import low_cost.entities.City;
import low_cost.entities.Path;
import low_cost.entities.Track;
import low_cost.utils.Checkers;
import low_cost.utils.ParametersReader;
import low_cost.utils.ResultSplitters;

import java.util.ArrayList;

public class LowCostBrowser {

    private TestsContainer testsContainer;
    private City[] cities;

    /**
     * Method run the browser
     */
    public void run(){
        init();
        calculate();
        printResults();
    }

    /**
     * Method initializes all parameters
     */
    private void init(){
        //Get parameters for initialization
        ArrayList<String> paramsList = ParametersReader.getParameters();
        //initialize current line for results list
        int currentLine = 0;
        //Get number of tests from results list
        int testsNumber = Integer.parseInt(paramsList.get(currentLine));
        //check tests number for max
        Checkers.checkMaxTests(testsNumber);
        //initialize tests container
        testsContainer = new TestsContainer(testsNumber);
        //get data from parameters list for init tests
        for (int testId = 1; testId <= testsNumber; testId++) {
            //get cities number for current test
            int citiesNumber = Integer.parseInt(paramsList.get(++currentLine));
            //check cities number for max
            Checkers.checkMaxCities(citiesNumber);
            //init cities array
            cities = new City[citiesNumber+1];
            //get data from parameters list for init cities for current test
            for (int cityId = 1; cityId <= citiesNumber; cityId++) {
                //get current city name from parameters list
                String cityName = paramsList.get(++currentLine);

                //get tracks number for current city
                int tracksNumber = Integer.parseInt(paramsList.get(++currentLine));

                ArrayList<Track> tempTracks = new ArrayList<>();
                //get data from parameters list for init tracks for current city
                for (int i = 0; i < tracksNumber; i++) {
                    //get connection's data from parameters list for current city
                    int[] values = ResultSplitters.getIntValuesFromLine(paramsList.get(++currentLine));
                    Track track = new Track(values[0],values[1]);
                    tempTracks.add(track);
                }

                //add current city to cities array
                cities[cityId] = new City(cityName, cityId, tempTracks);
            }
            ArrayList<Path> paths = new ArrayList<>();
            //get paths number from parameters list for current test
            int pathsNumber = Integer.parseInt(paramsList.get(++currentLine));
            //check tests number for max
            Checkers.checkMaxPaths(pathsNumber);
            //get start and end cities from parameters list for init paths for current test
            for (int i = 0; i < pathsNumber; i++) {
                String[] values = ResultSplitters.getStringValuesFromLine(paramsList.get(++currentLine));
                int startCityId = getCityIdByName(values[0]);
                int endCityId = getCityIdByName(values[1]);
                if(startCityId!=0&&endCityId!=0){
                    paths.add(new Path(startCityId,endCityId));
                }
            }
            //init test
            testsContainer.initTest(testId, paths, cities);
        }

    }

    /**
     * Method print results for all tests
     */
    private void printResults(){
        testsContainer.printTests();
    }

    /**
     * Method runs tests
     */
    private void calculate(){
        testsContainer.runTests();
    }
    private int getCityIdByName(String name){
        for (int i = 1; i<cities.length;i++){
            if (cities[i].getName().equals(name)){
                return cities[i].getId();
            }
        }
        return 0;
    }
}
