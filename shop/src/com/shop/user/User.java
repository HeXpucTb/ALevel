package com.shop.user;

import com.shop.bag.Bag;

public interface User {
    void setName(String name);
    void setPassword(String password);
    String getName();
    String getPassword();
    void payForPurchases();
    void setNewBuyerBag(String date, Bag bag);
    void showAllBaskets();
}
