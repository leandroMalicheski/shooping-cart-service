package com.macedo.leandro.services;

import com.macedo.leandro.models.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface ServiceUser {
    List<User> findAll();
    User findBy_id(ObjectId id);
    void saveUser(User user);
    void deleteUser(ObjectId id);

    boolean isValidUser(String email);
}
