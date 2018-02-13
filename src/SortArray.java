import java.util.Random;
import java.util.Scanner;

public class SortArray {
    Scanner in = new Scanner(System.in);
    public void callSortArray(){
        System.out.println("Условие задачи: ");
        System.out.println("Сортировка обменами. ");
        System.out.println("Дана последовательность чисел а 1 , а 2 , ..., а n .");
        System.out.println("Требуется переставить числа в порядке возрастания. Для этого сравниваются два");
        System.out.println("соседних числа аi  и a i+1 . Если а i  больше а i+1 , то делается перестановка.");
        System.out.println("Так продолжается до тех пор, пока все элементы не станут ");
        System.out.println("расположены в порядке возрастания.");
        System.out.println("Составить алгоритм сортировки, ");
        System.out.println("подсчитывая при этом количество перестановок.");
        System.out.println();
        System.out.println("Введите количество элементов: ");
        int n = in.nextInt();
        int [] arrayForSort = new int[n];
        Random random = new Random();
        for(int i = 0; i < n;i++){
            arrayForSort[i] = random.nextInt(n+10)+1;
        }
        System.out.println("Массив до сортировки:");
        for (int i:arrayForSort) {
            System.out.print(i+" ");
        }
        System.out.println();
        int counter = sortingArray(arrayForSort);
        System.out.println("Массив после сортировки:");
        for (int i:arrayForSort) {
            System.out.print(i+" ");
        }
        System.out.println("Отсортировано за "+counter+" перестановок");
        System.out.println();
    }
    public int sortingArray(int[] array){
        int begin = 0;
        int end = array.length - 1;
        boolean condition = true;
        int counter = 0;
        while (begin<end&&condition){
            condition = false;
            for(int i = begin; i < end;i++){
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    condition = true;
                    counter++;
                }
            }
            end--;
            for(int i = end; i > begin;i--){
                if(array[i-1]>array[i]){
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    condition = true;
                    counter++;
                }
            }
            begin++;
        }
        return counter;

    }
}
