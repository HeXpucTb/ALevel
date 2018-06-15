package calculators;

import java.util.Scanner;

public class RightBracesCalculator {
    private int countBraces;

    /**
     * Method calculates how much valid braces for specified amount
     * Catalan's relation used
     * @return count of right braces sequences
     */
    private long calculateNumberOfRightBraces(){

        //initialization array for every values
        long [] stock = new long[countBraces +1];

        //for countBraces == 0 valid braces only one
        if(countBraces ==0){
            return 1;
        }else {
            stock[0] = 1;

            //if count > 0 call Catalan's recurrence relation
            stock = doCatalansRelation(stock);

            //return the value for specified amount
            return stock[countBraces];
        }
    }

    /**
     * Method releases Catalan's recurrence relation
     * @param stock is adopted
     * @return results at long[] array
     */
    private long[] doCatalansRelation(long[] stock){
        //The Catalan numbers satisfy the recurrence relation:
        //Cn = C0Cn - 1 + C1Cn - 2 + C2Cn - 3 +...+ Cn - 2C1 + Cn - 1C0.
        for (int i = 1; i <= countBraces; i++) {
            stock[i] = 0;
            for (int j = 0; j < i; j++) {
                stock[i] += stock[j] * stock[i-j-1];
            }
        }
        return stock;
    }

    /**
     * Method reads and validates data from keyboard
     * @return int value
     */
    private int readNumber(){
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the count of braces:");
        while (true){
            try{
                count = Integer.parseInt(scanner.nextLine());
                if(count<0)throw new IllegalArgumentException();
                break;
            }catch (NumberFormatException e){
                System.out.println("Entered symbols isn't integer number, try again");
            }catch (IllegalArgumentException e){
                System.out.println("Number must be a positive number, try again:");
            }
        }
        return count;
    }

    /**
     * Method runs calculator and prints result
     */
    public void run(){
        countBraces = readNumber();
        System.out.println(calculateNumberOfRightBraces());
        System.out.println();
    }
}
