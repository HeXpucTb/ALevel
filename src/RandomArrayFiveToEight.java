import java.util.Random;
public class RandomArrayFiveToEight {
    public void randomArray(){
        System.out.println("Условие задачи: ");
        System.out.println("Создать двумерный массив из 8 строк по 5 столбцов в каждой");
        System.out.println("из случайных целых чисел из отрезка [10;99]");
        System.out.println("Вывести массив на экран.");
        System.out.println();
        final Random random = new Random();
        int [][] randArr = new int[8][5];
        for(int i = 0;i < 8; i++){
            for(int j = 0;j<5;j++){
                randArr[i][j] = Math.abs(random.nextInt(109)-10);
            }
        }
        for (int [] i: randArr) {
            for (int j: i) {
                if(j<10){
                    System.out.print("  "+j);
                }
                else {
                    System.out.print(" "+j);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
