package com.shop.shelf;

import com.shop.position.Position;
import com.shop.position.impl.Apple;
import com.shop.shelf.abst.AbstractShelf;

public class AppleShelf extends AbstractShelf{
    private Apple[] appleShelfPositions;
    public AppleShelf(Apple[] shelfPositions) {
        super(shelfPositions);
        appleShelfPositions = shelfPositions;
    }

    /*public Apple[] getAppleShelfPositions() {
        return appleShelfPositions;
    }

    public void setAppleShelfPositions(Apple[] appleShelfPositions) {
        this.appleShelfPositions = appleShelfPositions;
    }*/

    @Override
    public void putItem(int index, Position value) {
        appleShelfPositions[index] = (Apple) value;
    }

    @Override
    public Position getItem(int index) {
        return appleShelfPositions[index];
    }
    public int getLength(){
        return appleShelfPositions.length;
    }

    @Override
    public boolean checkAvailable(int count) {
        return false;
    }

    @Override
    public boolean checkIfEmpty(int index) {
        return false;
    }
}
