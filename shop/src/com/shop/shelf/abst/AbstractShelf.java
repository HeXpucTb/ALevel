package com.shop.shelf.abst;

import com.shop.position.Position;
import com.shop.shelf.Shelf;

public abstract class AbstractShelf implements Shelf{
    public int shelfLength;
    public Position[] shelfPositions;

    public int getShelfLength() {
        return shelfLength;
    }

    public void setShelfLength(int shelfLength) {
        this.shelfLength = shelfLength;
    }

    public Position[] getShelfPositions() {
        return shelfPositions;
    }

    public void setShelfPositions(Position[] shelfPositions) {
        this.shelfPositions = shelfPositions;
    }

    public AbstractShelf(Position[] shelfPositions) {
        this.shelfPositions = shelfPositions;
    }
}
