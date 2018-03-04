package com.shop.manager;
import com.shop.position.impl.Apple;
import com.shop.position.impl.Pen;
import com.shop.shelf.Shelf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShelfManager {
    private Scanner scanner = new Scanner(System.in);

    public Shelf<?> fillShelf(){
        Shelf<?> shelfOut = new Shelf<>(new ArrayList<>());
        System.out.println("Новая полка");
        System.out.println("Количество позиций:");
        int count = scanner.nextInt();
        System.out.println("Выберите тип полки:");
        System.out.println("1. Pens");
        System.out.println("2. Apples");
        switch (scanner.nextInt()) {
            case 1: {
                List<Pen> penList = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    penList.add(initPen());
                }
                Shelf<Pen> shelf = new Shelf<>(penList);
                shelfOut = shelf;
                break;
            }
            case 2: {
                List<Apple> appleList = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    appleList.add(initApple());
                }
                Shelf<Apple> shelf = new Shelf<>(appleList);
                shelfOut = shelf;
                break;
            }
        }
        return shelfOut;
    }
    public Pen initPen(){
        System.out.println("Введите наименование:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Введите цену:");
        Pen pen = new Pen(scanner.nextInt(),name);
        return pen;
    }
    public Apple initApple(){
        System.out.println("Введите наименование:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Введите цену:");
        Apple apple = new Apple(scanner.nextInt(),name);
        return apple;
    }

}
