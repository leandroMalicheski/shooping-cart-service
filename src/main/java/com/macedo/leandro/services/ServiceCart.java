package com.macedo.leandro.services;

import com.macedo.leandro.models.Cart;
import com.macedo.leandro.models.Item;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ServiceCart {

    void addItem();
    List<Item> listCartItem();
    List<Cart> findAll();
    Cart findBy_id(ObjectId id);
    void saveCart(Cart cart);
    void deleteCart(Cart cart);

    Cart findByUserId(ObjectId id);
}
