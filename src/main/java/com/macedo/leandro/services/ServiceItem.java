package com.macedo.leandro.services;

import com.macedo.leandro.models.Item;
import org.bson.types.ObjectId;

import java.util.List;

public interface ServiceItem {
    List<Item> findAll();
    Item findById(ObjectId id);
    void deleteItem(ObjectId id);
    void saveItem(Item item);
    void updateItem(Item item);
}
