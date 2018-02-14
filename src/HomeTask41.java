import java.util.Scanner;

public class HomeTask41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choise;
        do {
            System.out.println("Введите порядковый номер задачи: ");
            System.out.println("1 Ханойские башни");
            System.out.println("2 Сумма цифр числа, введенного с клавиатуры");
            System.out.println("3 Вывод чисел Фибоначчи");
            System.out.println("4 Счастливые трамвайные билетики");
            System.out.println("5 Симметрическая комбинация на часах");
            System.out.println("6 Двумерный массив 8 х 5 из случайных целых чисел");
            System.out.println("7 Двумерный массив 7 х 4 из случайных целых чисел");
            System.out.println("8 Сортировка обменами");
            System.out.println("Введите 0, если хотите выйти");
            System.out.println();
            choise = in.nextInt();
            switch (choise){
                case 1:{
                    HanoyTower towers = new HanoyTower();
                    towers.callHanoyTower();
                    break;
                }
                case 2:{
                    SumOfAllNumbersN sum = new SumOfAllNumbersN();
                    sum.callSumOfAllNum();
                    break;
                }
                case 3:{
                    FirstElevenFibonach firstEl = new FirstElevenFibonach();
                    firstEl.callFirstElFib();
                    break;
                }
                case 4:{
                    TramTickets sumLuckyTickets = new TramTickets();
                    sumLuckyTickets.luckyTikets();
                    break;
                }
                case 5:{
                    SymmetricTime resolve = new SymmetricTime();
                    resolve.symmetricTimeAlt();
                    break;
                }
                case 6:{
                    RandomArrayFiveToEight resolve = new RandomArrayFiveToEight();
                    resolve.randomArray();
                    break;
                }
                case 7: {
                    RandomArraySevenToFour resolve = new RandomArraySevenToFour();
                    resolve.randomArray();
                    break;
                }
                case 8:{
                    SortArray resolve = new SortArray();
                    resolve.callSortArray();
                    break;
                }
            }
        }while (choise != 0);

    }
}
