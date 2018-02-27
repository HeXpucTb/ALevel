package com.shop.bag;

import com.shop.position.Position;


public class ATBPacket implements Bag{
    private static final int SIZE = 10000;
    private Position[] positions = new Position[SIZE];
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

    public  Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public Position[] getPositions() {
        return positions;
    }
    @Override
    public int getNotUsedSize() {
        return SIZE - realIndex;
    }
    public void add(Position position){
        positions[realIndex++] = position;
    }
    public boolean haveNext(){
        return itteratorIndex<realIndex;
    }

    public Position next(){
        return positions[itteratorIndex++];
    }
    public void initIterator(){
        itteratorIndex = 0;
    }
}
