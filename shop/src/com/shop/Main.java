package com.shop;
import com.shop.bag.ATBPacket;
import com.shop.bag.Bag;
import com.shop.bag.BagImpl;
import com.shop.manager.AccountManager;
import com.shop.manager.ShelfManager;
import com.shop.manager.ShopManager;
import com.shop.position.Position;
import com.shop.shelf.Shelf;
import com.shop.user.User;
import com.shop.user.impl.Buyer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;
    private static List<Shelf> shelfList = new ArrayList<>();
    public static void main(String[] args){
        AccountManager accounts = new AccountManager();
        currentUser = initUser(accounts.getUserList());
        callShelfManager();
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
        while (bag.getNotUsedSize()!=0){
            printContent(shelfList);
            System.out.println("Выберите полку(введите -1, если закончили с покупками):");
            System.out.println("Если все полки пустые - позвать менеджера: введите -2");
            int shelf = scanner.nextInt();
            if(shelf==-1){
                break;
            }
            if (shelf==-2){
                callShelfManager();
                break;
            }
            System.out.println("выберите позицию:");
            int position = scanner.nextInt();
            if(shelfList.isEmpty()||shelfList.get(shelf).getShelfPositions().isEmpty()){
                System.out.println("Полка пуста");
                doPokupku(bag);
            }
            bag.add((Position) shelfList.get(shelf).getItem(position));
            shelfList.get(shelf).removeItem(position);
        }
        return bag;
    }
    private static void goNaKassu(Bag bag){
        ShopManager babaGalya = new ShopManager();
            babaGalya.sum(bag);
            Date date = new Date();
            String str = String.format("%tH:%<tM:%<tS",date);
            currentUser.setNewBuyerBag(str, babaGalya.getBag());
            }
    private static void printContent(List<Shelf> shelfList){
        for (int j = 0; j < shelfList.size(); j++) {
            System.out.println(j+"я полка:");
            for (int i = 0; i < shelfList.get(j).getLength(); i++) {
                Shelf<?> shelf = shelfList.get(j);
                Position position = (Position) shelf.getItem(i);
                System.out.println(i + "я позиция: " + position.getName() + " цена: " + position.getPrice());
            }
        }
    }
    private static User initUser(List<User> userList){
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
    private static void callShelfManager(){
        String more;
        do {
            ShelfManager shelfManager = new ShelfManager();
            shelfList.add(shelfManager.fillShelf());
            System.out.println("Добавить еще 1 полку?(yes/no)");
            more = scanner.next();
        }while (more.equals("yes"));
    }
}
