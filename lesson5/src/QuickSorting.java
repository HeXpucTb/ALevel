import java.util.Random;
import java.util.Scanner;

public class QuickSorting {
    private static int[] arrayForSort;
    public void callQuickSortMethod(){
        printTask();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество элементов массива для сортировки:");
        int n = in.nextInt();
        initializeArrayRandom(n);
        printArray(arrayForSort);
        sortByQuickMethod();
        printArray(arrayForSort);
    }
    private void printTask(){
        System.out.println("1 Quick Sort В начале выбирается “опорный” элемент массива.");
        System.out.println("Это может быть любое число, но от выбора этого элемента");
        System.out.println("сильно зависит эффективность алгоритма. Если нам известна медиана,");
        System.out.println("то лучше выбирать элемент, который как можно ближе к медиане.");
        System.out.println("В нашей реализации алгоритма, мы будем брать самый левый элемент, ");
        System.out.println("который в результате займет свое место. ");
        System.out.println("Элементы в массиве делятся на две части: слева те кто меньше опорного элемента, ");
        System.out.println("справа те кто больше. Таким образом опорный элемент занимает свое место");
        System.out.println("и больше никуда не двигается.");
        System.out.println("Для левого и правого массива действия повторяются рекурсивно.");
        System.out.println();
    }
    public void sortByQuickMethod(){
        int start = 0;
        int end = arrayForSort.length - 1;
        makeSort(start,end);
    }
    private void makeSort(int start,int end){
        if (start>=end) return;
        int startTemp = start;
        int endTemp = end;
        int current = startTemp - (startTemp - endTemp)/2;
        while (startTemp<endTemp){
            while ((arrayForSort[startTemp]<=arrayForSort[current])&&startTemp<current){
                startTemp++;
            }
            while ((arrayForSort[current]<=arrayForSort[endTemp])&&endTemp>current){
                endTemp--;
            }
            if(startTemp<endTemp){
                int temp = arrayForSort[startTemp];
                arrayForSort[startTemp] = arrayForSort[endTemp];
                arrayForSort[endTemp] = temp;
                if(startTemp == current){
                    current = endTemp;
                }
                else {
                    if(endTemp == current){
                        current = startTemp;
                    }
                }
            }
        }
        makeSort(start, current);
        makeSort(current+1, end);
    }
    private void initializeArrayRandom(int n){
        Random random = new Random();
        arrayForSort = new int[n];
        for(int i = 0; i < n;i++){
            arrayForSort[i] = random.nextInt(n);
        }
    }
    public void printArray(int [] array){
        for (int i: array) {
            System.out.print(" "+ i);
        }
        System.out.println();
    }
}
