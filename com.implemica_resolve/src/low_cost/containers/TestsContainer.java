package low_cost.containers;

import low_cost.entities.City;
import low_cost.entities.Path;
import low_cost.entities.Test;

import java.util.ArrayList;

public class TestsContainer {
    private Test[] tests;

    public TestsContainer(int testCount) {
        tests = new Test[testCount+1];
    }
    public void initTest(int id, ArrayList<Path> paths, City[] cities){
        tests[id] = new Test(id, paths, cities);
    }

    /**
     * Method runs printers for each test
     */
    public void printTests() {
        for (int i = 1; i < tests.length; i++) {
            if (tests[i]!=null){
                tests[i].printTheTestResults();
            }
        }
    }

    /**
     * Method runs each test
     */
    public void runTests(){
        for (int i = 1; i < tests.length; i++) {
            tests[i].runTest();
        }
    }
}
