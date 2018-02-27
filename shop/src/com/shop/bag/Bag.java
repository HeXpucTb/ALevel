package com.shop.bag;

import com.shop.position.Position;

public interface Bag {
    enum Status{OPEN, PAID}
    int getNotUsedSize();
    Position[] getPositions();
    void setPositions(Position[] positions);
    void add(Position position);
    boolean haveNext();
    Position next();
    void initIterator();
    Status getStatus();
    void setStatus(Status status);
    double getFinalSum();
    void setFinalSum(double finalSum);
}
