import java.util.Scanner;

public class LessonTasks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choise;
        do{
            System.out.println("Введите порядковый номер задачи: ");
            System.out.println("1 QuickSort");
            System.out.println("2 Labirinth");
            System.out.println("Введите 0, если хотите выйти");
            choise = in.nextInt();
            switch (choise){
                case 1:{
                    QuickSorting resolve = new QuickSorting();
                    resolve.callQuickSortMethod();
                    break;
                }
                case 2:{
                    LabyrinthGenerator resolve = new LabyrinthGenerator();
                    resolve.callLabyrinthResolve();
                    break;
                }
            }
        }while (choise!=0);
    }
}
