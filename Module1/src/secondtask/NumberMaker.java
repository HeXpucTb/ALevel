package secondtask;

import java.util.Random;
import java.util.Scanner;

public class NumberMaker {
    private int k;
    private int n;
    private int num;
    private Scanner scanner = new Scanner(System.in);
    public void initializeVars(){
        Random random = new Random();
        System.out.println("Укажите максимально возможное число:");
        n = scanner.nextInt();
        num = random.nextInt(n);
        System.out.println("Укажите количество попыток:");
        k = scanner.nextInt();
    }
    public void guessTheNumber(){
        for (int i = 0; i < k; i++) {
            System.out.println("угадайте число от 0 до "+n);
            int t = scanner.nextInt();
            if (t>num){
                System.out.println("Не угадали, введенное число больше загаданного");
            }
            if (t<num){
                System.out.println("Не угадали, введенное число меньше загаданного");
            }
            if (t==num){
                System.out.println("Верно!!");
                return;
            }
        }
        System.out.println("Попытки закончились!");
    }
}
