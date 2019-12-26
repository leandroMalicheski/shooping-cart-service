package com.macedo.leandro.services.impl;

import com.macedo.leandro.models.Cart;
import com.macedo.leandro.models.Item;
import com.macedo.leandro.repositories.CartRepository;
import com.macedo.leandro.services.ServiceCart;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceCartImpl implements ServiceCart {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public void addItem() {

    }

    @Override
    public List<Item> listCartItem() {
        return null;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findBy_id(ObjectId id) {
        return null;
    }

    @Override
    public void saveCart(Cart cart) {

    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public Cart findByUserId(ObjectId id) {
        Query findByUserId = new Query();
        findByUserId.addCriteria(Criteria.where("userId").is(id.toHexString()));
        Cart cart = mongoOperations.findOne(findByUserId, Cart.class);
        return cart;
    }
}
