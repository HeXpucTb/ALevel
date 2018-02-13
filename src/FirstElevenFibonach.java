import java.util.Scanner;

public class FirstElevenFibonach {
    Scanner in = new Scanner(System.in);
    public void callFirstElFib(){
        System.out.println("Условие задачи:");
        System.out.println("Выведите на экран первые 11 членов последовательности Фибоначчи.");
        System.out.println("Напоминаем, что первый и второй члены последовательности равны");
        System.out.println("единицам, а каждый следующий — сумме двух предыдущих.");
        System.out.println("Модернизировано до ввода количества чисел Фибоначчи");
        System.out.println();
        System.out.println("Введите количество чисел Фибоначчи:");
        int countFib = in.nextInt();
        firstElevenFib(countFib);
    }
    private void firstElevenFib(int count){
        int number1 = 1;
        int number2 = 1;
        int fib;
        System.out.print(number1 + " " + number2);
        for(int i = 2; i < count;i++){
            fib = number1 + number2;
            number1 = number2;
            number2 = fib;
            System.out.print(" " + number2);
        }
        System.out.println();
        System.out.println();
    }
}
