package com.shop.manager;

import com.shop.bag.Bag;
import com.shop.position.Position;

import java.util.Arrays;
import java.util.Comparator;

public class ShopManager {
    private Position[] bagWithoutNull;
    private Bag bag;
    public double sum(Bag bag){
        double sum = 0;
        removeNullFromBag(bag);
        sortBag();
        printBagContent();
        if(bagWithoutNull[0]==null){
            return sum;
        }
        else {
            sum = sumSalePositions(bagWithoutNull.length,0, sum);
            System.out.println("vasha suma sostavlaet " + sum);
        }
        bag.setFinalSum(sum);
        return sum;
    }
    public void sortBag(){
        Arrays.sort(bagWithoutNull, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.getPrice()>o2.getPrice()){
                    return -2;
                }
                if(o1.getPrice()<o2.getPrice()){
                    return 2;
                }
                return 0;
            }
        });

    }
    public void removeNullFromBag(Bag bag){
        this.bag = bag;
        int notNullCount = 0;
        Position[] tempArray = bag.getPositions();
        for(int i = 0; i<tempArray.length;i++){
            if(tempArray[i]!=null){
                notNullCount++;
            }
        }
        if(notNullCount==0){
            bagWithoutNull = new Position[1];
            return;
        }
        bagWithoutNull = new Position[notNullCount];
        for (int i = 0; i < bagWithoutNull.length; i++) {
            for (int j = 0; j < tempArray.length; j++) {
                if(tempArray[j]!=null){
                    bagWithoutNull[i] = tempArray[j];
                    tempArray[j]=null;
                    break;
                }
            }
        }
    }
    private double sumSalePositions(int length,int index, double sum){
        if (index==length){
            return sum;
        }
        if(index==length-1){
            return sum+bagWithoutNull[index].getPrice();
        }
        if (index+2==length){
            return sum + bagWithoutNull[index].getPrice() + bagWithoutNull[index+1].getPrice();
        }
        else {
            System.out.println(bagWithoutNull[length-1].getName()+" бесплатно!!");
            sum = sum + bagWithoutNull[index].getPrice() + bagWithoutNull[index+1].getPrice();
            return sumSalePositions(length - 1,index+2, sum);}
    }
    private void printBagContent(){
        for (int i = 0;i<bagWithoutNull.length;i++) {
            System.out.println(i+"я позиция, цена"+bagWithoutNull[i].getPrice()+", имя: "+bagWithoutNull[i].getName());
        }
    }

    public Bag getBag() {
        bag.setPositions(bagWithoutNull);
        return bag;
    }
}
