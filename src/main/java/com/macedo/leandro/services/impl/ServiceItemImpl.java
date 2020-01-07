package com.macedo.leandro.services.impl;

import com.macedo.leandro.models.Item;
import com.macedo.leandro.repositories.ItemRepository;
import com.macedo.leandro.services.ServiceItem;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceItemImpl implements ServiceItem {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findBy_id(ObjectId id) {
        return itemRepository.findBy_id(id);
    }

    @Override
    public void deleteItem(ObjectId id) {
        itemRepository.delete(itemRepository.findBy_id(id));
    }

    @Override
    public void saveItem(Item item) {
        item.set_id(ObjectId.get());
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }
}
