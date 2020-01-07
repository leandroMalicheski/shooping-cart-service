package com.macedo.leandro.services.impl;

import com.macedo.leandro.models.Cart;
import com.macedo.leandro.models.Item;
import com.macedo.leandro.repositories.CartRepository;
import com.macedo.leandro.services.ServiceCart;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class ServiceCartImpl implements ServiceCart {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(ObjectId id) {
        return cartRepository.findById(id);
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public Cart findByUserId(ObjectId id) {
        Query findByUserId = new Query();
        findByUserId.addCriteria(Criteria.where("userId").is(id.toHexString()));
        return mongoOperations.findOne(findByUserId, Cart.class);
    }

    @Override
    public Cart addItem(ObjectId id, Item item) {
        Cart cart = cartRepository.findById(id);
        if(cart.getItems() != null){
            for (Item currentItem: cart.getItems()) {
                if (item.getId() == currentItem.getId()){
                    int newQty = currentItem.getQty() + 1;
                    currentItem.setQty(newQty);
                }
            }
        }else{
            cart.setItems(Arrays.asList(item));
        }
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart removeItem(ObjectId id, Item item) {
        Cart cart = cartRepository.findById(id);
        List<Item> collection = cart.getItems();

        Item itemFound = collection.stream().filter(currentItem -> item.getId().equals(currentItem.getId())).findAny().orElse(null);

        if(itemFound != null && item.getQty() >=1 ){
            int newQty = itemFound.getQty() - 1;
            itemFound.setQty(newQty);
        }else{
            collection.removeIf(e -> e.getId().equals(item.getId()));
        }

        cart.setItems(collection);
        cartRepository.save(cart);
        return cart;
    }
}
