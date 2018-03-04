package com.shop.user.impl;
import com.shop.bag.Bag;
import com.shop.position.Position;
import com.shop.user.User;

import java.util.*;

public class Buyer implements User{
    private String name;
    private String password;
    private Map<String,Bag> clientBags;
    public Buyer(){
        clientBags = new HashMap<>();
    }
    public void initializeNewUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        setName(scanner.nextLine());
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        System.out.println("Повторите пароль:");
        if (scanner.nextLine().equals(password)){
            setPassword(password);
            System.out.println("успешно!");
            return;
        } else {
            initializeNewUser();
        }
    }
    public boolean initializeUser(List<User> userList){
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(user.getName().equals(name)&&user.getPassword().equals(password)){
                setName(name);
                setPassword(password);
                check =  true;
            }
        }
        return check;
    }
    public void setNewBuyerBag(String date,Bag bag){
        clientBags.put(date,bag);
    }
    public Map<String,Bag> getClientBags(){
        return clientBags;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    public void payForPurchases(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите корзину, которую оплачиваем:");
        showAllBaskets();
        System.out.println("Введите время заказа:");
        clientBags.get(scanner.nextLine()).setStatus(Bag.Status.PAID);
    }
    public void showAllBaskets(){
        Set keys = getBagKeys();
        for (Object key: keys) {
            List<Position> positions = clientBags.get(key).getPositions();
            System.out.println(key+" дата корзины, статус - "+clientBags.get(key).getStatus());
            System.out.println("В корзине находятся:");
            for (int j = 0; j < positions.size(); j++) {
                System.out.println(positions.get(j).getName()+" , цена - "+positions.get(j).getPrice());
            }
            System.out.println("На сумму(с учетом акции)"+clientBags.get(key).getFinalSum());
        }
    }
    private Set getBagKeys(){
        Set keys = clientBags.keySet();
        return keys;
    }
}
