package examples;

import java.util.Scanner;

public class ExampleOfNumberFormatException extends Example{
    private String[] alphabet;
    public String[] callNumFormatEx(){
        boolean exit = false;
        while (!exit){
        try(Scanner scanner = new Scanner(System.in)){

                System.out.println("Инициализируйте массив алфавита (0 - выйти безинициализации)");
                System.out.println("Колличество букв");
                scanner.nextLine();
                int index = scanner.nextInt();
                if (index == 0) return alphabet;
                alphabet = new String[index];
                for (int i = 0; i < alphabet.length; i++) {
                    System.out.println(i + 1 + "я буква");
                    alphabet[i] = scanner.next();
                }
                exit = true;
            }
        }
        return alphabet;
    }
}
