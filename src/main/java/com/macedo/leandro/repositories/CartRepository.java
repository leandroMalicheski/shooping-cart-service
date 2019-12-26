package com.macedo.leandro.repositories;

import com.macedo.leandro.models.Cart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findBy_id(ObjectId _id);
}
