package com.macedo.leandro.repositories;

import com.macedo.leandro.models.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    Item findById(ObjectId id);
}
