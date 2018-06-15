import calculators.RightBracesCalculator;
import calculators.SumOfNumbersCalculator;
import low_cost.LowCostBrowser;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        RightBracesCalculator rightBracesCalculator = new RightBracesCalculator();
        LowCostBrowser browser = new LowCostBrowser();
        SumOfNumbersCalculator sumCalculator = new SumOfNumbersCalculator();
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
        System.out.println("0 - exit;");
    }
}
