package task4;

import java.util.Scanner;

public abstract class LikeMaker {
    public static int makeChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What will we do?");
        System.out.println("Add new entity - 1");
        System.out.println("Add like to an entity - 2");
        System.out.println("Cancel the like - 3");
        System.out.println("Show users made likes - 4");
        System.out.println("Show entity likes - 5");
        System.out.println("Show user likes - 6");
        System.out.println("Exit - 0");
        return sc.nextInt();
    }
}
