package com.macedo.leandro.services;

import com.macedo.leandro.models.Item;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ServiceItem {
    List<Item> findAll();
    Item findBy_id(ObjectId id);
    void deleteItem(ObjectId id);
    void saveItem(Item item);
}
