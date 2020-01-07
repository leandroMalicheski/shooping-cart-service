package com.macedo.leandro.repositories;

import com.macedo.leandro.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findById(ObjectId id);
}
