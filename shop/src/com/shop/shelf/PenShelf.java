package com.shop.shelf;

import com.shop.position.Position;
import com.shop.position.impl.Pen;
import com.shop.shelf.abst.AbstractShelf;

public class PenShelf extends AbstractShelf{
    private Pen[] penShelfPositions;
    public PenShelf(Pen[] shelfPositions) {
        super(shelfPositions);
        penShelfPositions = shelfPositions;
    }

    /*public Pen[] getPenShelfPositions() {
        return penShelfPositions;
    }

    public void setPenShelfPositions(Pen[] penShelfPositions) {
        this.penShelfPositions = penShelfPositions;
    }*/
    @Override
    public void putItem(int index, Position pen) {
        penShelfPositions[index] = (Pen) pen;
    }

    @Override
    public Position getItem(int index) {
        return shelfPositions[index];
    }
    public int getLength(){
        return penShelfPositions.length;
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
