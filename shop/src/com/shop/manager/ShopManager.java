package com.shop.manager;

import com.shop.bag.Bag;
import com.shop.position.Position;

import java.util.Collections;
import java.util.List;

public class ShopManager {
    private List<Position> finalBagPositions;
    private Bag bag;

    public double sum(Bag bag){
        this.bag = bag;
        double sum = 0;
        finalBagPositions = bag.getPositions();
        Collections.sort(finalBagPositions);
        printBagContent();
        if(finalBagPositions.isEmpty()){
            return sum;
        }
        else {
            sum = sumSalePositions(finalBagPositions.size(),0, sum);
            System.out.println("vasha suma sostavlaet " + sum);
        }
        bag.setFinalSum(sum);
        return sum;
    }

    private double sumSalePositions(int length,int index, double sum){
        if (index==length){
            return sum;
        }
        if(index==length-1){
            return sum+ finalBagPositions.get(index).getPrice();
        }
        if (index+2==length){
            return sum + finalBagPositions.get(index).getPrice() + finalBagPositions.get(index+1).getPrice();
        }
        else {
            System.out.println(finalBagPositions.get(length-1).getName()+" бесплатно!!");
            sum = sum + finalBagPositions.get(index).getPrice() + finalBagPositions.get(index+1).getPrice();
            return sumSalePositions(length - 1,index+2, sum);}
    }

    private void printBagContent(){
        for (int i = 0; i< finalBagPositions.size(); i++) {
            System.out.println(i+"я позиция, цена: "+ finalBagPositions.get(i).getPrice()+", имя: "+ finalBagPositions.get(i).getName());
        }
    }

    public Bag getBag() {
        bag.setPositions(finalBagPositions);
        return bag;
    }
}
