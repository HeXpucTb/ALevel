package thirdtask;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayChecker {
    public Integer[] initArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество эл-тов массива:");
        int n = scanner.nextInt();
        Integer array[] = new Integer[n];
        for (int i = 0;i<array.length;i++) {
            System.out.println("Введите эл-т массива:");
            array[i] = scanner.nextInt();
        }
        return array;
    }
    public int checkArray(Integer[] array){
        Set<Integer> list = new HashSet<>();
        for (Integer i: array) {
            list.add(i);
        }
        return list.size();
    }
}
