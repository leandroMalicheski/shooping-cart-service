package com.macedo.leandro.services.impl;

import com.macedo.leandro.controllers.UserController;
import com.macedo.leandro.models.Cart;
import com.macedo.leandro.models.User;
import com.macedo.leandro.repositories.UserRepository;
import com.macedo.leandro.services.ServiceCart;
import com.macedo.leandro.services.ServiceUser;
import com.macedo.leandro.vo.UserVO;
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

    @Autowired
    ServiceCart serviceCart;

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
    public UserVO saveUser(User user) {
        UserVO userVO = new UserVO(false);
        if(isValidUser(user.getEmail())){
            ObjectId userId = ObjectId.get();
            logger.info("Adding user name:{}", user.getName());
            user.set_id(userId);
            userRepository.save(user);

            userVO.setValid(true);
            userVO.setUser(user);
            logger.info("Generating cart for:{}", user.getName());
            serviceCart.saveCart(new Cart(userId));
        }
        return userVO;



    }

    @Override
    public void deleteUser(ObjectId id) {
        Cart cart = serviceCart.findByUserId(id);
        userRepository.delete(userRepository.findBy_id(id));
        serviceCart.deleteCart(cart);
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

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
