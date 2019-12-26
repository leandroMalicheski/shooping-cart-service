package com.macedo.leandro.services.impl;

import com.macedo.leandro.controllers.UserController;
import com.macedo.leandro.models.Cart;
import com.macedo.leandro.models.User;
import com.macedo.leandro.repositories.UserRepository;
import com.macedo.leandro.services.ServiceUser;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceUserImpl implements ServiceUser {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MongoOperations mongoOperations;

    Logger logger = LoggerFactory.getLogger(ServiceUserImpl.class);

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findBy_id(ObjectId id) {
        return userRepository.findBy_id(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(ObjectId id) {
        userRepository.delete(userRepository.findBy_id(id));
    }

    @Override
    public boolean isValidUser(String email) {
        boolean isValid = false;
        logger.info("Validating User");

        Query findByUserEmail = new Query();
        findByUserEmail.addCriteria(Criteria.where("email").is(email));
        User user = mongoOperations.findOne(findByUserEmail, User.class);
        if (user == null){
            isValid = true;
        }
        return isValid;
    }
}
