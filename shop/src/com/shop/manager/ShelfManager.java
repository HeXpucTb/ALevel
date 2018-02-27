package com.shop.manager;
import com.shop.position.impl.Apple;
import com.shop.position.impl.Pen;
import com.shop.shelf.AppleShelf;
import com.shop.shelf.PenShelf;
import com.shop.shelf.Shelf;

import java.util.Scanner;

public class ShelfManager {
    Shelf shelf;
    public Shelf createNewShelf(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Размер полки?:");
            int length = scanner.nextInt();
            System.out.println("Какую полку создаем?");
            System.out.println("1 Pen");
            System.out.println("2 Apple");
            switch (scanner.nextInt()){
                case 1:{
                    PenShelf penShelf = new PenShelf(addItemsToPenShelf(length));
                    shelf = penShelf;
                    break;
                }
                case 2:{
                    AppleShelf appleShelf = new AppleShelf((addItemsToAppleShelf(length)));
                    shelf = appleShelf;
                    break;
                }
            }
        return shelf;
    }
    private Pen[] addItemsToPenShelf(int length){
        Scanner scanner = new Scanner(System.in);
        Pen[] array = new Pen[length];
        for (int i = 0;i<length;i++){
            System.out.println("Цена ручки:");
            double price = scanner.nextDouble();
            System.out.println("Наименование:");
            scanner.nextLine();
            String name = scanner.nextLine();
            array[i] = new Pen(price,name);
        }
        return array;
    }
    private Apple[] addItemsToAppleShelf(int length){
        Scanner scanner = new Scanner(System.in);
        Apple[] array = new Apple[length];
        for (int i = 0;i<length;i++){
            System.out.println("Цена яблока:");
            double price = scanner.nextDouble();
            System.out.println("Наименование:");
            scanner.nextLine();
            String name = scanner.nextLine();
            array[i] = new Apple(price,name);
        }
        return array;
    }
}
