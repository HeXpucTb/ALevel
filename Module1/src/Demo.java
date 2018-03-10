import fourthtask.PasswordsChecker;
import secondtask.NumberMaker;
import thirdtask.ArrayChecker;

import java.util.Scanner;

public class Demo {
    private static boolean exit;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Выберите задачу:");
            System.out.println("1 Взаимодействие между классами");
            System.out.println("2 Угадай число");
            System.out.println("3 Количество разных элементов");
            System.out.println("4 Топ10 паролей");
            System.out.println("0 - выйти");
            switch (scanner.nextInt()){
                case 0:{
                    exit = true;
                    break;
                }
                case 1:{
                    break;
                }
                case 2:{
                    NumberMaker example2 = new NumberMaker();
                    example2.initializeVars();
                    example2.guessTheNumber();
                    break;
                }
                case 3:{
                    ArrayChecker example3 = new ArrayChecker();
                    int n = example3.checkArray(example3.initArray());
                    System.out.println("Количество разных элементов в данном массиве - "+n);
                    break;
                }
                case 4: {
                    PasswordsChecker exapmple4 = new PasswordsChecker();
                    exapmple4.addPasswordsToList();
                    exapmple4.checkOverlap();
                    exapmple4.returnTop10PasswordsList();
                    exapmple4.print10Top(exapmple4.getTop10());
                    break;
                }
            }
        }while (!exit);

    }
}
