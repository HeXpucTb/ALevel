import java.util.Random;

public class RandomArraySevenToFour {
    public void randomArray(){
        final Random random = new Random();
        int [][] randomArr = new int[7][4];
        System.out.println("Условие задачи: ");
        System.out.println("Создать двумерный массив из 7 строк по 4 столбцов в каждой");
        System.out.println("из случайных целых чисел из отрезка [-5;5].");
        System.out.println("Вывести массив на экран. Определить и вывести на экран ");
        System.out.println("индекс строки с наибольшим по модулю произведением элементов.");
        System.out.println("Если таких строк несколько, то вывести индекс первой встретившейся из них.");
        System.out.println();
        for(int i = 0;i < 7; i++){
            for(int j = 0;j<4;j++){
                randomArr[i][j] = random.nextInt(10)-5;
            }
        }
        for (int [] i: randomArr) {
            for (int j: i) {
                if(j>=0){
                    System.out.print("  "+j);
                }
                else{
                    System.out.print(" "+j);
                }
                }
            System.out.println();
            }
            System.out.println();
        sumArrayString(randomArr);
    }
    public void sumArrayString(int[][]array){
        int sum2 = 0;
        int index = -1;
        for(int i = 0; i < array.length;i++){
            int sum1 = 0;
            for(int j = 0; j < array[i].length;j++ ){
                int k = Math.abs(array[i][j]);
                sum1 += k;
            }
            if(sum1>sum2&&index<i){
                sum2 = sum1;
                index = i;
            }
        }
        System.out.println("Cтрока с наибольшей суммой по модулю = "+sum2);
        System.out.println("Индекс этой строки (начиная с 0) = "+index);
        System.out.println();
    }

}
