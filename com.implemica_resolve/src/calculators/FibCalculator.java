package calculators;

import java.util.Scanner;

public class FibCalculator {
    private int n;
    public void run(){
        int a;
        int b = 1;
        int fib = 0;
        setN();
        for (int i = 0; i <n ; i++) {
            a=fib;
            fib = a+b;
            b=a;
        }
        System.out.println(fib);
    }
    private void setN(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        n = sc.nextInt();
    }
}
