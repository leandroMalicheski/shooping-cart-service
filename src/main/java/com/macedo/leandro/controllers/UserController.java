package com.macedo.leandro.controllers;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    ServiceUser serviceUser;
    @Autowired
    ServiceCart serviceCart;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping()
    public List<User> getAllUser() {
        logger.info("Returning all users");
        return serviceUser.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") ObjectId id) {
        logger.info("Returning user id:{}", id);
        return serviceUser.findBy_id(id);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
        logger.info("Updating user id:{}", id);
        serviceUser.saveUser(user);
    }

    @PostMapping()
    public UserVO createUser(@Valid @RequestBody User user) {

        UserVO userVO = new UserVO(false);
        if(serviceUser.isValidUser(user.getEmail())){
            ObjectId userId = ObjectId.get();
            logger.info("Adding user name:{}", user.getName());
            user.set_id(userId);
            serviceUser.saveUser(user);
            userVO.setValid(true);
            userVO.setUser(user);
            logger.info("Generating cart for:{}", user.getName());
            serviceCart.saveCart(new Cart(userId));
        }
        return userVO;
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        Cart cart = serviceCart.findByUserId(id);
        logger.info("Removing user id:{} and cart id: {}", id, cart.get_id());
        serviceUser.deleteUser(id);
        serviceCart.deleteCart(cart);
    }

}
