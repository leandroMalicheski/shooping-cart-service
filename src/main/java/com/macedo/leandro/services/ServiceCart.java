package com.macedo.leandro.services;

import com.macedo.leandro.models.Cart;
import com.macedo.leandro.models.Item;
import org.bson.types.ObjectId;

import java.util.List;

public interface ServiceCart {

    List<Cart> findAll();
    Cart findById(ObjectId id);

    void saveCart(Cart cart);
    void deleteCart(Cart cart);

    Cart findByUserId(ObjectId id);
    Cart addItem(ObjectId id, Item item);
    Cart removeItem(ObjectId id, Item item);
}
