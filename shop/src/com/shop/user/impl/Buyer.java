package com.shop.user.impl;

import com.shop.bag.ATBPacket;
import com.shop.bag.Bag;
import com.shop.position.Position;
import com.shop.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buyer implements User{
    private String name;
    private String password;
    private ArrayList<Bag> clientBags;
    public Buyer(){
        clientBags = new ArrayList<>();
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
    public void setNewBuyerBag(Bag bag/*,Position[] positions*/){
        /*ATBPacket tempBag = new ATBPacket();
        tempBag.setPositions(positions);
        tempBag.setStatus(bag.getStatus());*/
        clientBags.add(bag);
    }
    public ArrayList<Bag> getClientBags(){
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
        System.out.println("№ корзины:");
        clientBags.get(scanner.nextInt()).setStatus(Bag.Status.PAID);
    }
    public void showAllBaskets(){
        for (int i = 0; i<clientBags.size();i++){
            Position[] positions = clientBags.get(i).getPositions();
            System.out.println(i+"я корзина, статус - "+clientBags.get(i).getStatus());
            System.out.println("В корзине находятся:");
            for (int j = 0; j < positions.length; j++) {
                System.out.println(positions[j].getName()+" , цена - "+positions[j].getPrice());
            }
            System.out.println("На сумму(с учетом акции)"+clientBags.get(i).getFinalSum());
        }
    }
}
