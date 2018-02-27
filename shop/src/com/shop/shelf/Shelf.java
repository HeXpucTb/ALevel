package com.shop.shelf;

import com.shop.position.Position;

public interface Shelf {
   void putItem(int index,Position value);
   Position getItem(int index);
   boolean checkAvailable(int count);
   boolean checkIfEmpty(int index);
   int getLength();
}
