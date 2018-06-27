import calculators.*;
import week_day.*;
import low_cost.LowCostBrowser;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        RightBracesCalculator rightBracesCalculator = new RightBracesCalculator();
        LowCostBrowser browser = new LowCostBrowser();
        SumOfNumbersCalculator sumCalculator = new SumOfNumbersCalculator();
        MaxDividerCalculator dividerCalc = new MaxDividerCalculator();
        WeekDayGetter dayGetter = new WeekDayGetter();
        FlatPositionCalculator flatPositionCalculator = new FlatPositionCalculator();
        FibCalculator fibCalculator = new FibCalculator();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        do{
            printMessage();
            switch (sc.nextInt()){
                case 1:{
                    rightBracesCalculator.run();
                    break;
                }
                case 2:{
                    browser.run();
                    break;
                }
                case 3:{
                    sumCalculator.run();
                    break;
                }
                case 4:{
                    dividerCalc.run();
                    break;
                }
                case 5:{
                    dayGetter.run();
                    break;
                }
                case 6:{
                    flatPositionCalculator.run();
                    break;
                }
                case 7:{
                    fibCalculator.run();
                    break;
                }
                case 0:{
                    exit = true;
                }
            }
        }while (!exit);
    }
    private static void printMessage(){
        System.out.println("Select task for resolve:");
        System.out.println("1 - Correct brace expression;");
        System.out.println("2 - The cheapest way;");
        System.out.println("3 - Sum of 100!;");
        System.out.println("4 - Max divider for two numbers;");
        System.out.println("5 - Get week day;");
        System.out.println("6 - Flat position;");
        System.out.println("7 - Fibonacci calculator;");
        System.out.println("0 - exit;");
    }
}
