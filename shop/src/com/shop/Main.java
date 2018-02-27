package com.shop;

import com.shop.bag.ATBPacket;
import com.shop.bag.Bag;
import com.shop.bag.BagImpl;
import com.shop.manager.AccountManager;
import com.shop.manager.ShelfManager;
import com.shop.manager.ShopManager;
import com.shop.shelf.Shelf;
import com.shop.user.User;
import com.shop.user.impl.Buyer;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static User currentUser;
    private static Shelf[] shelfArray;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        AccountManager accounts = new AccountManager();
        currentUser = initUser(accounts.getUserList());
        callShopManager();
        System.out.println("Выберем пакет");
        Bag bag = selectBag();
        while (true){
            System.out.println("Shito delaem desy?");
            System.out.println("1 Go za pokypkami");
            System.out.println("2 Go na kassy");
            System.out.println("3 Оплатим пакет покупок");
            System.out.println("4 Вывести инфо о всех ваших покупках");
            System.out.println("5 Exit");
            switch (scanner.nextInt()){
                case 1: bag = doPokupku(bag); break;
                case 2: goNaKassu(bag);break;
                case 3: currentUser.payForPurchases();
                case 4: currentUser.showAllBaskets();break;
                case 5: System.exit(0);
            }
        }
    }
    private static Bag selectBag(){
        Scanner scanner = new Scanner(System.in);
        Bag bag;
        System.out.println("S chem poidem vasia?");
        System.out.println("1: ATB power");
        System.out.println("2: Standart edition Galia");
        switch (scanner.nextInt()){
            case 1:
                bag = new ATBPacket();
                break;
            case 2:
                bag = new BagImpl();
                break;
            default:
                System.out.println("sho zirkaech? pognali s rukzacom");
                bag = new BagImpl();
        }
        return bag;
    }
    private static Bag doPokupku(Bag bag){
        Scanner scanner = new Scanner(System.in);
        while (bag.getNotUsedSize()!=0){
            printContent(shelfArray);
            System.out.println("Выберите полку(введите -1, если закончили с покупками):");
            System.out.println("Если все полки пустые - позвать менеджера: введите -2");
            int shelf = scanner.nextInt();
            if(shelf==-1){
                break;
            }
            if (shelf==-2){
                callShopManager();
                break;
            }
            System.out.println("выберите позицию:");
            int position = scanner.nextInt();
            if(shelfArray[shelf].getItem(position)!=null) {
                bag.add(shelfArray[shelf].getItem(position));
                shelfArray[shelf].putItem(position, null);
            }else System.out.println("Позиция пуста");
        }
        return bag;
    }
    private static void goNaKassu(Bag bag){
        ShopManager babaGalya = new ShopManager();
            babaGalya.sum(bag);
            currentUser.setNewBuyerBag(babaGalya.getBag());
            }
    private static void printContent(Shelf[] array){
        for (int j = 0; j < array.length; j++) {
            System.out.println(j+"я полка:");
            for (int i = 0; i < array[j].getLength(); i++) {
                Shelf item = array[j];
                if(item.getItem(i)!=null) {
                    item.getItem(i).getName();
                    System.out.println(i + "я позиция: " + item.getItem(i).getName() + " цена: " + item.getItem(i).getPrice());
                }
                else {
                    System.out.println(i + "я позиция пустая");
                }
            }
        }
    }
    private static User initUser(List<User> userList){
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = new Buyer();
        System.out.println("Представимся:");
        System.out.println("n - если вы новый пользователь");
        System.out.println("u - если у вас есть аккаунт");
        if (scanner.next().equals("n")){
            buyer.initializeNewUser();
            return buyer;
        }
        if(scanner.next().equals("u")){
            if(buyer.initializeUser(userList)){
                return buyer;
            }
        }
        return buyer;
    }
    private static void callShopManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько полок необходимо?");
        int shelfCount = scanner.nextInt();
        shelfArray = new Shelf[shelfCount];
        for (int i = 0; i < shelfCount; i++) {
            ShelfManager shelfManager = new ShelfManager();
            shelfArray[i] = shelfManager.createNewShelf();
        }
    }
}
