package com.shop.shelf;
import java.util.List;

public class Shelf<T> {
    private List<T> shelfPositions;
   public Shelf(List<T> positions){
       shelfPositions = positions;
   }
    public void putItem(T position) {
        shelfPositions.add(position);
    }
    public T getItem(int index) {
        return shelfPositions.get(index);
    }
    public void removeItem(int index){
       shelfPositions.remove(index);
    }
    public int getLength(){
        return shelfPositions.size();
    }
    public List<T> getShelfPositions(){
       return shelfPositions;
    }
}
