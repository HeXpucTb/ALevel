import java.util.Scanner;

public class SumOfAllNumbersN {
    public static int sum;
    Scanner in = new Scanner(System.in);
    public void callSumOfAllNum(){
        System.out.println("Условие задачи:");
        System.out.println("Для введённого пользователем с клавиатуры");
        System.out.println("натурального числа посчитайте сумму всех его цифр");
        System.out.println("(заранее не известно сколько цифр будет в числе).");
        System.out.println();
        System.out.println("Введите натуральное число:");
        int k = in.nextInt();
        System.out.println("Сумма его цифра равна:"+sumOfAllNumbersAlt(k));
    }
    public int sumOfAllNumbers(int n){
        if(n<10){
            return sum+n;
        }
        sum +=n%10;
        return sumOfAllNumbers(n/10);
    }
    public int sumOfAllNumbersAlt(int n){
        int sum = 0;
        while (n>10){
            sum = sum + n % 10;
            n /= 10;
        }
        sum = sum+n;
        return sum;
    }
}
