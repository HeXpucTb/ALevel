package com.shop.bag;

import com.shop.position.Position;

import java.util.List;

public interface Bag{
    enum Status{OPEN, PAID}
    int getNotUsedSize();
    List<Position> getPositions();
    void setPositions(List<Position> positions);
    void add(Position position);
    boolean haveNext();
    Position next();
    void initIterator();
    Status getStatus();
    void setStatus(Status status);
    double getFinalSum();
    void setFinalSum(double finalSum);
}
