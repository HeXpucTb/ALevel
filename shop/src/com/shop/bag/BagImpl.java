package com.shop.bag;

import com.shop.position.Position;

import java.util.ArrayList;
import java.util.List;

public class BagImpl implements Bag {
    private static final int SIZE = 10;
    private List<Position> positions = new ArrayList<>(SIZE);
    private int realIndex = 0;
    private int itteratorIndex = 0;
    private Status status = Status.OPEN;
    private double finalSum = 0;

    public double getFinalSum() {
        return finalSum;
    }

    public void setFinalSum(double finalSum) {
        this.finalSum = finalSum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public int getNotUsedSize() {
        return SIZE - realIndex;
    }
    public void add(Position position){
        positions.add(realIndex++,position);
    }
    public boolean haveNext(){
        return itteratorIndex<realIndex;
    }

    public Position next(){
        return positions.get(itteratorIndex++);
    }
    public void initIterator(){
        itteratorIndex = 0;
    }
}
