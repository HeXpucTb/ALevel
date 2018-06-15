package low_cost.utils;

public abstract class Checkers {
    private static final int MAX_CITIES_NUMBER = 10000;
    private static final int MAX_TESTS_NUMBER = 10000;
    private static final int MAX_PATHS_NUMBER = 10000;
    public static void checkMaxTests(int number){
        if(number>MAX_TESTS_NUMBER){
            System.out.println("Tests limit was reached, rerun");
            System.exit(0);
        }
    }
    public static void checkMaxCities(int number){
        if(number>MAX_CITIES_NUMBER){
            System.out.println("Cities limit was reached, rerun");
            System.exit(0);
        }
    }
    public static void checkMaxPaths(int number){
        if(number>MAX_PATHS_NUMBER){
            System.out.println("Paths limit was reached, rerun");
            System.exit(0);
        }
    }
}
