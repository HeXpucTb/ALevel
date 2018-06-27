package calculators;

import java.util.Scanner;

public class MaxDividerCalculator {
    private int first;
    private int second;
    public void run(){
        int currentDivider;
        int maxDivider = 1;
        setNumbers();
        if (first>second){
            currentDivider=second;
        }else currentDivider=first;
        for (int i = 1; i <= currentDivider ; i++) {
            if(first%i==0&&second%i==0){
                if (maxDivider<i)maxDivider=i;
            }
        }
        System.out.println("Max divider is "+maxDivider);
    }
    private void setNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:");
        first = sc.nextInt();
        System.out.println("Enter second number:");
        second = sc.nextInt();
    }
}
