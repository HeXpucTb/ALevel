package calculators;

import java.math.BigInteger;

public class SumOfNumbersCalculator {
    /**
     * Method calculates a sum of numbers at a result of 100!
     * @return the sum at int value
     */
    private int calculateSumOfNumbers() {
        int result = 0;
        BigInteger[] results;

        //Save a result of the calculateFactorialOfHundred method
        BigInteger factorialOfHundred = calculateFactorialOfHundred();

        //Do a loop while factorialOfHundred will be less 1 symbol
        while (factorialOfHundred.bitLength()>1){
            results = factorialOfHundred.divideAndRemainder(BigInteger.TEN);

            //Sum a result with the reminder of the division
            result += results[1].intValue();
            factorialOfHundred = results[0];
        }
        return result;
    }

    /**
     * Method calculates factorial of 100
     * @return result at BigInteger
     */
    private BigInteger calculateFactorialOfHundred(){
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            result = result.multiply(new BigInteger(""+i));
        }
        return result;
    }

    /**
     * Method runs calculator and prints result
     */
    public void run(){
        System.out.println(calculateSumOfNumbers());
        System.out.println();
    }
}
